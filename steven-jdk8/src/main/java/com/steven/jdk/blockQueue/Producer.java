package com.steven.jdk.blockQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Steven on 2017/5/25.
 */
public class Producer implements Runnable {

    private BlockingQueue queue = null;

    public Producer(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
