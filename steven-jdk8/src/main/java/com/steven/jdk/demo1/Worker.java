package com.steven.jdk.demo1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 工人类
 * Created by Steven on 2017/5/18.
 */
public class Worker {

    private String name;        // 名字
    private long workDuration;  // 工作持续时间

    public Worker(String name, long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    public void doWork(){
        System.out.println(name + " begins to work...");
        try {
            Thread.sleep(workDuration); // 用休眠模拟工作执行的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " has finished the job...");
    }

    /**
     * 测试线程
     */
    static class WorkerTestThread implements Runnable {

        private Worker worker;
        private CountDownLatch cdLatch;

        public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
            this.worker = worker;
            this.cdLatch = cdLatch;
        }
        @Override
        public void run() {
            worker.doWork();        // 让工人开始工作
            cdLatch.countDown();    // 工作完成后倒计时次数减1
        }
    }


}
class  CountDownLatchTest {
    private static final int MAX_WORK_DURATION = 5000;  // 最大工作时间
    private static final int MIN_WORK_DURATION = 1000;  // 最小工作时间

    // 产生随机的工作时间
    private  long  getRandomWorkDuration(long min, long max) {
        return (long) (Math.random() * (max - min) + min);
    }
    public static void main(String[] args) {
        CountDownLatchTest s = new CountDownLatchTest();
        CountDownLatch latch = new CountDownLatch(3);   // 创建倒计时闩并指定倒计时次数为2
        Worker w1 = new Worker("骆昊", s.getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        Worker w2 = new Worker("王大锤", s.getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        Worker w3 = new Worker("孙离", s.getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));

        new Thread(new Worker.WorkerTestThread(w1, latch)).start();
        new Thread(new Worker.WorkerTestThread(w2, latch)).start();
        new Thread(new Worker.WorkerTestThread(w3, latch)).start();

        try {
            latch.await();  // 等待倒计时闩减到0
            System.out.println("All jobs have been finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConcurrentHashMap map = new ConcurrentHashMap();


    }

}



