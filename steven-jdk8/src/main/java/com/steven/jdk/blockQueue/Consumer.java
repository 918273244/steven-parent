package com.steven.jdk.blockQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Steven on 2017/5/25.
 */
public class Consumer implements Runnable {


    private BlockingQueue queue = null;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
