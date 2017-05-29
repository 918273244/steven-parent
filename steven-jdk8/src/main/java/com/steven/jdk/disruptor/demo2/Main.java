package com.steven.jdk.disruptor.demo2;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import javax.swing.event.InternalFrameEvent;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * Created by Steven on 2017/5/28.
 */
public class Main {

    public static void main(String[] args) {
        //创建ringBuffer
        RingBuffer<Order> ringBuffer = RingBuffer.create(ProducerType.MULTI, new EventFactory<Order>() {
            @Override
            public Order newInstance() {
                return new Order();
            }
        },1024,new YieldingWaitStrategy());


        SequenceBarrier barriers = ringBuffer.newBarrier();
        Consumer[] consumers = new Consumer[3];
        for(int i = 0; i < consumers.length; i++){
            consumers[i] = new Consumer("c" + i);
        }

        WorkerPool<Order> workerPool = new WorkerPool<Order>(ringBuffer,barriers,new IntEventExceptionHandler(),consumers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(Executors.newFixedThreadPool(4));

        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 2; i++) {
            final Producer producer = new Producer(ringBuffer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("次数 start");
                        latch.await();
                        System.out.println("次数 end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 3; j++) {
                        producer.onData(UUID.randomUUID().toString());
                    }
                }
            }).start();

        }

        try {
            Thread.sleep(3000);
            System.out.println("---------------开始生产-----------------");
            latch.countDown();
            Thread.sleep(5000);
            System.out.println("总数:" + consumers[0].getCount() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
