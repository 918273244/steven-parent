package com.steven.jdk.works;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Steven on 2017/5/26.
 */
public class Call {

    public static void main(String[] args) {
        Worker worker = new Worker();
        //work传入work
        Master master = new Master(worker,10);
        //生成100个task任务
        for (int i = 0; i <1000 ; i++) {
            Task task = new Task();
            task.setName("i:"+i);
            task.setId(i);
            task.setPrice( (int)(Math.random()*1000));
            master.addQueue(task);
        }
        master.executor();


        master.sum();
       /* while (true){
            long startTime = System.currentTimeMillis();
            ConcurrentHashMap<String, Object> concurrentHashMap = master.concurrentHashMap;
            if(concurrentHashMap.size()>0&&!master.isComplete()){
                int total = 0;
                for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()){
                    total +=(int)entry.getValue();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("一共用时:"+(endTime-startTime)+" : 总金额: "+total);
                break;
            }
        }*/
    }
}
