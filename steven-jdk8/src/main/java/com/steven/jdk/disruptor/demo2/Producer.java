package com.steven.jdk.disruptor.demo2;

import com.lmax.disruptor.RingBuffer;

/**
 * Created by Steven on 2017/5/28.
 */
public class Producer {

    final RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void onData(String data){

        long sequence = ringBuffer.next();
        try {
            Order order = ringBuffer.get(sequence);
            order.setName(data);
        }finally {
            ringBuffer.publish(sequence);
        }
    }

}
