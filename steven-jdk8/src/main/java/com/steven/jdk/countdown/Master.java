package com.steven.jdk.countdown;


import com.steven.jdk.works.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Steven on 2017/5/27.
 */
public class Master {
    //消息容器
    ConcurrentLinkedQueue<Task> list = new ConcurrentLinkedQueue<>();
    //map
    Map<String, Thread> map = new HashMap<>();
    //汇总容器
    ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
    //计数器
    CountDownLatch latch =null;
    //线程池
    ExecutorService service ;
    //work对象
    Worker worker = null;

    /**
     * 实例化master
     * @param worker
     * @param threadCount
     */
    public Master(Worker worker, int threadCount){
        this.worker = worker;
        service =  Executors.newFixedThreadPool(5);
        worker.setLinkedQueue(list);
        latch = new CountDownLatch(5);
        worker.setCountDownLatch(latch);
        worker.setConcurrentHashMap(concurrentHashMap);
        for (int i = 0; i < threadCount; i++) {
            map.put("key : "+i,new Thread(worker));
        }

    }

    /**
     * 加入task到队列
     * @param task
     */
    public void addTask(Task task){
        list.offer(task);
    }

    /**
     * 启动线程池
     */
    public void exector(){
        for(Map.Entry<String, Thread>  me: map.entrySet()){
            service.submit(me.getValue());
        }
    }

    public int getTotalPrice(){
        int total = 0;
        for (Map.Entry<String, Object>  map : concurrentHashMap.entrySet()){
            total+=(Integer) map.getValue();
        }
        return total;
    }

    /**
     * 等待
     */
    public void countWait(){
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭线程池
     */
    public void shutdown(){
        service.shutdown();
    }

}
