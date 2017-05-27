package com.steven.jdk.countdown;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Steven on 2017/5/27.
 */
public class Worker implements Runnable {

    ConcurrentLinkedQueue<Task> linkedQueue = null;
    ConcurrentHashMap<String, Object> concurrentHashMap = null;
    CountDownLatch countDownLatch = null;

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void setLinkedQueue(ConcurrentLinkedQueue<Task> linkedQueue) {
        this.linkedQueue = linkedQueue;
    }

    public void setConcurrentHashMap(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true){
            Task task = linkedQueue.poll();
            if(task == null) break;
            Object obj = handle(task);
            concurrentHashMap.put(task.getName(),obj);
        }
        System.out.println("跳出循环");
        countDownLatch.countDown();
    }

    //方法处理
    public Object handle(Task task){
        Object o = null;
        try {
            Thread.sleep(500);
            o = task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
