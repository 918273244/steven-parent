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
            if (queue.poll() == null){
                break;
            }else {
                handler(queue);
            }

        }

    }

    public void handler(ConcurrentLinkedQueue queue){
        try {
            Thread.sleep(50);
            Task task =  (Task) queue.poll();
            concurrentHashMap.put("任务id:"+task.getName(),task.getPrice());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* Task task =  (Task) queue.poll();
        concurrentHashMap.put("任务id:"+task.getName(),task.getPrice());*/


    }
}
