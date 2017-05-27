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
        Master master = new Master(worker,4);
        //生成100个task任务
        for (int i = 0; i <100 ; i++) {
            Task task = new Task();
            task.setName("i:"+i);
            task.setId(i);
            task.setPrice( (int)(Math.random()*1000));
            master.addQueue(task);
        }
        master.executor();

        long startTime = System.currentTimeMillis();

//        master.sum();
        while (true){
            if(master.isComplete()){
               int total =  master.getResult();
                long endTime = System.currentTimeMillis();
                System.out.println("一共用时:"+(endTime-startTime)+" : 总金额: "+total);
                break;
            }
        }
    }
}
