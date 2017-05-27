package com.steven.jdk.countdown;

import java.util.Random;

/**
 * Created by Steven on 2017/5/27.
 */
public class Call {

    public static void main(String[] args) {
        Master master = new Master(new Worker(), 10);
        for (int i = 0; i <100 ; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("name:"+i);
            task.setPrice(new Random().nextInt(1000));
            master.addTask(task);
        }

        master.exector();
        master.shutdown();


        long startTime = System.currentTimeMillis();
        master.countWait();

        long endTime= System.currentTimeMillis();
        System.out.println("总金额："+master.getTotalPrice()+" : 一共耗时："+(endTime-startTime));



    }
}
