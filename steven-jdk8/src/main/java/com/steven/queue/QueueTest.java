package com.steven.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Steven on 2017/6/16.
 */
public class QueueTest {
    private int MAX = 3;
    public static Queue<String> queue = new ConcurrentLinkedQueue<>();
    private final static Lock lock = new ReentrantLock();
    final Condition full = lock.newCondition();
    final Condition empty = lock.newCondition();
    private int count = 0;


    class AddQueus extends Thread{

        @Override
        public void run() {
            while (count < 5){
                lock.lock();
                try{
                    System.out.println("生产： "+queue.size());
                    while (queue.size() == MAX){
                        System.out.println("------警告：队列满了!");
                        full.await();
                    }

                    queue.add("第"+count+"个");
                    empty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void start(){
        new AddQueus().start();
        new RemoveQueue().start();
    }


 class RemoveQueue extends Thread{


        public RemoveQueue(){}

    @Override
    public void run() {
        while (count <= 5){
            lock.lock();
            try{
                System.out.println("消费："+queue.size());
                while (queue.size() == 0){
                    System.out.println("------警告：现在盘子是空的");
                    empty.await();
                }
                empty.await();

                System.out.println(queue.poll());
                count++;
                full.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(queue.poll());

        }
    }
}


    public static void main(String[] args) throws InterruptedException {
        QueueTest y = new QueueTest();
        y.start();
    }

}
