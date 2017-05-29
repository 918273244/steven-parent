package com.steven.jdk.disruptor.demo2;

import com.lmax.disruptor.WorkHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Steven on 2017/5/28.
 */
public class Consumer implements WorkHandler<Order> {

    String consumerId;
    static AtomicInteger count = new AtomicInteger(0);


    public Consumer( String consumerId){
        this.consumerId=consumerId;
    }

    @Override
    public void onEvent(Order order) throws Exception {
        System.out.println("当前消费者: " + this.consumerId + "，消费信息：" + order.getName());
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}
