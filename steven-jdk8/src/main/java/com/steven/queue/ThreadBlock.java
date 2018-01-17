package com.steven.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 建立一个阻塞队列
 * 一个基于已链接节点的、范围任意的 blocking queue。
 * 此队列按 FIFO（先进先出）排序元素。
 * 队列的头部 是在队列中时间最长的元素;队列的尾部 是在队列中时间最短的元素。
 * 新元素插入到队列的尾部，并且队列获取操作会获得位于队列头部的元素。
 * 链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中，其可预知的性能要低。
 * Created by Steven on 2017/6/16.
 */
public class ThreadBlock {

    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
    private int count = 0;


    class Producer extends Thread{
        @Override
        public void run() {
            while (count < 15) {
                try {
                    queue.put("放入第："+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }

    class Customer extends Thread{
        @Override
        public void run() {
            while (count <= 15) {
                System.out.println(queue.size());
                // 取出一个对象
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(count);
            }
    }

    public void start(){
        new Producer().start();
        new Customer().start();
    }

    public static void main(String[] args) {
        ThreadBlock b = new ThreadBlock();
        b.start();
    }


}
