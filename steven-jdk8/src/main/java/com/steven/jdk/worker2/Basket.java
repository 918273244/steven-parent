package com.steven.jdk.worker2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 装苹果的篮子
 * Created by Steven on 2017/5/26.
 */
public class Basket {
    // 篮子，能够容纳3个苹果
    BlockingQueue<String> basket = new LinkedBlockingDeque<String>(3);

    // 生产苹果，放入篮子
    public void produce() throws InterruptedException {
        // put方法放入一个苹果，若basket满了，等到basket有位置
        basket.put("An apple");
    }

    // 消费苹果，从篮子中取走
    public String consume() throws InterruptedException {
        // take方法取出一个苹果，若basket为空，等到basket有苹果为止(获取并移除此队列的头部)
        return basket.take();
    }

}
