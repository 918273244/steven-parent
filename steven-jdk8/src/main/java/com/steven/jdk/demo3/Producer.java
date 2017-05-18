package com.steven.jdk.demo3;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * Created by Steven on 2017/5/18.
 */
public class Producer implements Runnable{
    private BlockingQueue<Task> buffer;

    public Producer(BlockingQueue<Task> buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while(true) {
            try {
                Task task = new Task();
                buffer.put(task);
                System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
