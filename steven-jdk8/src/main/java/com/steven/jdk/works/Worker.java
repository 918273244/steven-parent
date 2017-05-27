package com.steven.jdk.works;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * worker
 * Created by Steven on 2017/5/26.
 */
public class Worker implements Runnable{

     ConcurrentLinkedQueue queue = null;
     ConcurrentHashMap<String, Object> concurrentHashMap = null;

    public void setQueue(ConcurrentLinkedQueue queue) {
         this.queue = queue;
    }

    public void setConcurrentHashMap(ConcurrentHashMap<String, Object> concurrentHashMap) {
         this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        while (true){
            Task task = (Task) queue.poll();
            if (task == null){
                break;
            }else {
                Object obj = handler(task);
                concurrentHashMap.put("任务id:"+task.getName(),obj);
            }

        }

    }

    public Object handler(Task task){
        Object o = null;
        try {
            Thread.sleep(50);
            o = task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  o;
    }
}
