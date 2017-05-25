package com.steven.jdk.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue 属于有界队列
 * Created by Steven on 2017/5/25.
 */
public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
