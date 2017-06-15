package com.steven.mapdb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Steven on 2017/6/15.
 */
public class ObjectWAL<E> {

    // 当前写入的文件
    private final static String CURRENT = "current.o";
    // 当前合并过后的有效文件
    private final static String PRE = "pre.o";
    // 当前正在合并的文件
    private final static String MERGE_CURRENT = "merge_current.o";
    // 当前正在合并过后的有效文件
    private final static String MERGE_PRE = "merge_pre.o";
    // 当前正在合并过后的有效临时文件
    private final static String TEMP_PRE = "temp_pre.o";
    // 合并时候mapdb临时文件
    private final static String DBFILE = "o_wal";

    private final static int BUFFSER_SIZE = 1024000;
    // long + int的字节数
    private final static int COUNT = 8 + 4;
    private RandomAccessFile raFile;
    private FileChannel fileChannel;
    private boolean restoring;
    private boolean merging;
    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFSER_SIZE * 5);
    private ByteBuffer contentBuffer = ByteBuffer.allocateDirect(BUFFSER_SIZE);
    private Object mergeLock = new Object();
    private String baseDir;

    public ObjectWAL(String baseDir, String name)
    {
        this.baseDir = baseDir + File.separator + name + File.separator;
        File file = new File(baseDir);
        if (!file.exists())
        {
            file.mkdirs();
        }
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                ObjectWAL.this.close();
            }
        });
    }


    /**
     * 在文件后面增加内容
     * @param seq
     * @param content
     */
    public void addContent(long seq, E content){
        try{
            byte[] c = null;
            int count = 0;
            if (content != null)
            {
                c = JSON.toJSONBytes(content, SerializerFeature.WriteClassName);
                count = c.length;
            }
            synchronized(this)
            {
                if (contentBuffer.capacity() >= COUNT + count)
                {
                    contentBuffer.clear();
                    contentBuffer.putLong(seq);
                    contentBuffer.putInt(count);
                    if (c != null)
                    {
                        contentBuffer.put(c);
                    }
                    contentBuffer.flip();
                    fileChannel.write(contentBuffer);
                }
                else    // 大于容量，直接写
                {
                    raFile.writeLong(seq);
                    raFile.writeInt(count);
                    if (c != null)
                    {
                        raFile.write(c);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在文件后面删除
     * @param seq
     */
    public void remove(long seq){
        try
        {
            synchronized(this)
            {
                contentBuffer.clear();
                contentBuffer.putLong(seq);
                contentBuffer.putInt(0);
                contentBuffer.flip();
                fileChannel.write(contentBuffer);
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 在文件后面增加删除的内容
     *
     */
    public void removeMulit(long ... seqs)
    {
        if (seqs == null || seqs.length < 1)
        {
            return;
        }
        try
        {
            int size = seqs.length;
            ByteBuffer tempBuffer = ByteBuffer.allocateDirect(size * COUNT);
            tempBuffer.clear();
            for (long s : seqs)
            {
                tempBuffer.putLong(s);
                tempBuffer.putInt(0);
            }
            tempBuffer.flip();
            // 写入文件
            synchronized(this)
            {
                fileChannel.write(tempBuffer);
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }


    /**
     * 在文件后面增加删除的内容
     *
     * @param nodes
     */
    public void remove(List<Node<E>> nodes)
    {
        if (nodes == null || nodes.size() < 1)
        {
            return;
        }
        try
        {
            int size = nodes.size();
            ByteBuffer tempBuffer = ByteBuffer.allocateDirect(size * COUNT);
            tempBuffer.clear();
            for (Node<E> s : nodes)
            {
                tempBuffer.putLong(s.getSeq());
                tempBuffer.putInt(0);
            }
            tempBuffer.flip();
            // 写入文件
            synchronized(this)
            {
                fileChannel.write(tempBuffer);
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 宕机或kill进程后恢复
     *
     */
    protected void restore(Map<Long, E> maps)
    {
        restoring = true;
        try
        {
            // 按顺序恢复
            File preT = new File(baseDir + PRE);
            File tempC = new File(baseDir + MERGE_CURRENT);
            File tempP = new File(baseDir + MERGE_PRE);
            if (preT.exists())
            {
                // 两者同时出现，会出现在上次合并完成后，已经把合并文件更名为pre了，在
                // 还没有删除被合并文件的时候，宕机或kill了进程，因此此时可以删除合并
                // 文件，只要用pre和current即可
                tempC.delete();
                tempP.delete();
                preT.renameTo(tempP);
            }
            // 前合并文件存在
            if (tempP.exists())
            {
                readWAL(tempP, maps);
            }
            // 合并文件存储
            if (tempC.exists())
            {
                readWAL(tempC, maps);
            }
            // 当前文件
            File temp = new File(baseDir + CURRENT);
            if (temp.exists())
            {
                readWAL(temp, maps);
            }

            File tempT = new File(baseDir + TEMP_PRE);
            writeWAL(tempT, maps);
            tempT.renameTo(preT);
            tempC.delete();
            tempP.delete();

            if (raFile != null)
            {
                raFile.close();
            }
            temp.delete();
            raFile = new RandomAccessFile(baseDir + CURRENT, "rw");
            fileChannel = raFile.getChannel();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        restoring = false;
    }

    /**
     *
     */
    public void merge()
    {
        synchronized(mergeLock)
        {
            if (merging)     // 正在合并
            {
                return;
            }
        }
        try
        {
            synchronized(mergeLock)
            {
                merging = true;
            }
            File tempC = new File(baseDir + MERGE_CURRENT);
            File tempP = new File(baseDir + MERGE_PRE);
            File temp = new File(baseDir + CURRENT);
            File preT = new File(baseDir + PRE);
            if (preT.exists())
            {
                preT.renameTo(tempP);
            }
            synchronized(this)
            {
                if (restoring)   // 恢复过程中，不要合并
                {
                    return;
                }
                try
                {
                    if (raFile != null)
                    {
                        raFile.close();
                    }
                    temp.renameTo(tempC);
                    raFile = new RandomAccessFile(baseDir + CURRENT, "rw");
                    fileChannel = raFile.getChannel();
                }
                catch(Throwable e)
                {
                    e.printStackTrace();
                }
            }
            File file = new File(baseDir + DBFILE);
            File fileP = new File(baseDir +  DBFILE + ".p");
            File parent = file.getParentFile();
            if (!parent.exists())
            {
                parent.mkdirs();
            }
            // 删除存在的文件
            file.delete();
            fileP.delete();
            DB db = DBMaker.newFileDB(file)
                    //.closeOnJvmShutdown()
                    .transactionDisable()
                    .cacheWeakRefEnable()
                    .mmapFileEnable()
                    .make();
            Map<Long, E> maps = db.getHashMap("tempMap");
            if (tempP.exists())
            {
                readWAL(tempP, maps);
            }
            if (tempC.exists())
            {
                readWAL(tempC, maps);
            }
            File tempT = new File(baseDir + TEMP_PRE);
            writeWAL(tempT, maps);
            tempT.renameTo(preT);
            tempC.delete();
            tempP.delete();

            db.close();
            file.delete();
            fileP.delete();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 这里没有必要同步，最多下次合并
            merging = false;
        }
    }


    /**
     *
     * @param file
     * @param maps
     */
    private void readWAL(File file, Map<Long, E> maps)
    {
        RandomAccessFile reader = null;
        try
        {
            reader = new RandomAccessFile(file, "r");
            FileChannel channel = reader.getChannel();
            long seq;
            int len;
            byte[] cont;
            long length = reader.length();
            long position = 0;
            int count;
            boolean last = false;
            while (!last)
            {
                byteBuffer.clear();
                count = channel.read(byteBuffer, position);
                if (count <= 0)
                {
                    break;
                }
                byteBuffer.flip();
                last = position + count >= length;
                while (byteBuffer.remaining() >= 12)
                {
                    seq = byteBuffer.getLong();
                    len = byteBuffer.getInt();
                    if (byteBuffer.remaining() >= len)
                    {
                        position += 12;
                        if (len > 0)
                        {
                            cont = new byte[len];
                            byteBuffer.get(cont);
                            E sc = (E)JSON.parse(cont);
                            maps.put(seq, sc);
                            position += len;
                        }
                        else
                        {
                            maps.remove(seq);
                        }
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        catch(EOFException eof)
        {
            // 文件结束
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch(Throwable e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param maps
     */
    private void writeWAL(File file, Map<Long, E> maps)
    {
        if (file.exists())
        {
            file.delete();
        }
        RandomAccessFile writer = null;
        try
        {
            writer = new RandomAccessFile(file, "rw");
            FileChannel channel = writer.getChannel();
            Set<Long> keys = maps.keySet();
            byte[] c;
            int count;
            E content;
            //
            byteBuffer.clear();
            for (Long temp : keys)
            {
                content = maps.get(temp);
                if (content != null)
                {
                    c = JSON.toJSONBytes(content, SerializerFeature.WriteClassName);
                    count = c.length;
                }
                else
                {
                    c = null;
                    count = 0;
                }
                if (byteBuffer.remaining() < 12 + count)   // 不足空间，写入文件
                {
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                    byteBuffer.clear();
                }
                byteBuffer.putLong(temp);
                byteBuffer.putInt(count);
                if (c != null)
                {
                    byteBuffer.put(c);
                }
            }
            if (byteBuffer.remaining() > 0)   // 还有内容
            {
                byteBuffer.flip();
                channel.write(byteBuffer);
                byteBuffer.clear();
            }
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch(Throwable e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     */
    public void close()
    {
        try
        {
            if (raFile != null)
            {
                raFile.close();
            }
            byteBuffer = null;
            contentBuffer = null;
            fileChannel = null;
            raFile = null;
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
    }

}
