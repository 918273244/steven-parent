package com.steven.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Steven on 2017/6/15.
 */
public class ObjectWALQueues<E extends Serializable> {

    private static final Map<String, Boolean> EXISTS = new HashMap<>();
    // 数据存储文件名
    private static final String FILE_NAME = "temp_data";
    private static final String MESSAGES = "messages";
    // 日志记录
    private ObjectWAL<E> objectWal;
    // 记录短信信息，key值为seq值，value对短信信息
    private BlockingQueue<Node<E>> messages;

    //计数器
    private AtomicInteger messagesLength;

    // 序号产生器
    private AtomicLong seq;
    private Semaphore semaphore;
    private boolean countFlag;

    public ObjectWALQueues(int count, long minutes, String dir, String queueName) throws Exception
    {
        init(count, minutes, dir, queueName);
    }

    public int size(){
        return messagesLength.get();
    }

    private void init(int count, long minutes, String baseDir, String queueName) throws Exception{
        String dir = baseDir + File.separatorChar + queueName + File.separatorChar + FILE_NAME;
        File file = new File(dir);
        if (EXISTS.containsKey(file.getAbsolutePath()))
        {
            throw new Exception("同一路径下不可有重复的队列名：" + dir);
        }
        EXISTS.put(file.getAbsolutePath(), true);
        File fileP = new File(dir + ".p");
        File parent = file.getParentFile();
        if (!parent.exists())
        {
            parent.mkdirs();
        }
        file.delete();
        fileP.delete();

        DB db = DBMaker.newFileDB(file)
                //.closeOnJvmShutdown()
                //.commitFileSyncDisable()
                .transactionDisable()
                .cacheSize(1024000)
                .cacheWeakRefEnable()
                .mmapFileEnable()
                .make();

        messages = db.getQueue(MESSAGES);
        Map<Long, E> map = db.getHashMap(MESSAGES + "map");
        objectWal = new ObjectWAL<>(baseDir, queueName);
        objectWal.restore(map);
        messagesLength = new AtomicInteger();
        seq = new AtomicLong();
        // 从存储中恢复队列数据
        Set<Long> keys = map.keySet();
        Node<E> value;
        for (Long key : keys){
            value = new Node<>(key, map.get(key));
            messages.add(value);
            messagesLength.incrementAndGet();
            // 因为恢复时候肯定是单线程在处理，所以这里简单处理
            long v = seq.get();
            // 按照序号生成规则，在正数范围内，后续的序号比前面的大，在负数范围反之
            if ((key < 0 && v >= 0) || (((key > 0 && v >= 0) || (key < 0 && v < 0)) && key > v))
            {
                seq.set(key);
            }
        }
        // 恢复到下一个序号
        seq.incrementAndGet();

        // 达到count条数改变后合并日志
        if (count > 0){
            semaphore = new Semaphore(0);
            CountThread ct = new CountThread(objectWal, semaphore, count);
            ct.start();
            countFlag = true;
        }

        if (minutes > 0)
        {
            TimeThread tt = new TimeThread(objectWal, minutes * 60000L);
            tt.start();
        }
    }

    /**
     * 信息放入集合队列中，供后续使用.
     * 同时返回该内容内部设置的seq值，该seq值根据需要决定是否使用.
     * @param con
     */
    public Long addContent(E con)
    {
        // 获取队列内部序号
        long s = seq.getAndIncrement();
        // 设置值到db中
        Node<E> value = new Node<>(s, con);
        // 记录到当前使用队列中
        messages.add(value);
        messagesLength.incrementAndGet();
        // 记录到日志中
        objectWal.addContent(s, con);
        change(1);
        return s;
    }

    /**
     * 从集合中删除使用过的数据。在调用该方法前，一定是通过该对象
     * 中的获取某个队列中的seq值后，否则数据有垃圾
     * @param seq
     */
    public void remove(long seq)
    {
        objectWal.remove(seq);
        change(1);
    }

    /**
     *
     * @param p
     */
    private void change(int p)
    {
        if (countFlag)
        {
            semaphore.release(p);
        }
    }

    /**
     * 从集合中删除使用过的数据。在调用该方法前，一定是通过该对象
     * 中的获取某个队列中的seq值后，否则数据有垃圾
     * @param nodes
     */
    public void remove(List<Node<E>> nodes)
    {
        objectWal.remove(nodes);
        if (nodes != null)
        {
            change(nodes.size());
        }
    }

    /**
     * 从队列中获取count数量的值，并把这些值从队列中删除，
     * 但不从日志中删除，在使用完成这些值后，需要自行
     * 调用remove方法以便把这些值从日志中删除；如果不删除虽然
     * 当前队列中已经不存在该值了，但是如果一定宕机或kill掉进程
     * 进行数据恢复的时候，又会把这些值恢复回来。
     * 如果队列中有足够的值，该方法返回需要数量的值；如果队列中
     * 的值不足count，则返回队列中所有的值。
     * 返回list为node对象集合，在node中有原始E对象值。
     * 注意获取得到的node对象中的seq值不能够修改，否则在调用
     * remove方法移除的时候不能够正确移除。
     * @param count，需要获取的数量
     * @return
     */
    public List<Node<E>> peek(int count)
    {
        List<Node<E>> ret = new ArrayList<>();
        Node<E> node;
        for (int i = 0; i < count; i++)
        {
            node = messages.poll();
            messagesLength.decrementAndGet();
            if (node == null)
            {
                break;
            }
            ret.add(node);
        }
        return ret;
    }


    static class CountThread extends Thread{
        private ObjectWAL<?> objectWal;
        private Semaphore semaphore;
        private int count;


        /**
         *
         * @param tm
         */
        public CountThread(ObjectWAL<?> objectWal, Semaphore semaphore, int count)
        {
            super("wal_merge_count");
            this.setDaemon(true);
            this.objectWal = objectWal;
            this.semaphore = semaphore;
            this.count = count;
        }

        public void run()
        {
            while (true)
            {
                try
                {
                    // 获取信号量，信号量以设置的条数为准
                    semaphore.acquire(count);
                    objectWal.merge();
                }
                catch(Exception e)
                {
                }
            }
        }
    }

    /**
     * 定时数据刷新存盘线程
     *
     */
    static class TimeThread extends Thread
    {
        private ObjectWAL<?> objectWal;
        private long millis;

        /**
         *
         * @param tm
         */
        public TimeThread(ObjectWAL<?> objectWal, long millis)
        {
            super("wal_merge_time");
            this.setDaemon(true);
            this.objectWal = objectWal;
            this.millis = millis;
        }

        /**
         *
         *(non-Javadoc)
         * @see java.lang.Thread#run()
         *
         */
        public void run()
        {
            while (true)
            {
                try
                {
                    Thread.sleep(millis);
                    objectWal.merge();
                }
                catch(Exception e)
                {
                }
            }
        }
    }
}



