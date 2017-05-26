package com.steven.jdk.worker2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程模拟生产者消费者
 * Created by Steven on 2017/5/26.
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueueTest test = new BlockingQueueTest();
        // 建立一个装苹果的篮子
        Basket basket = new Basket();

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        Producer producer = new Producer("生产者1",basket);
        Producer producer2 = new Producer("生产者2",basket);
        Producer producer3 = new Producer("生产者3",basket);

        Consumer consumer = new Consumer("消费者001", basket);
        Consumer consumer2 = new Consumer("消费者002", basket);

        service.submit(producer);
        service.submit(producer2);
        service.submit(producer3);

        service.submit(consumer);
        service.submit(consumer2);

        // 程序运行5s后，所有任务停止
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
