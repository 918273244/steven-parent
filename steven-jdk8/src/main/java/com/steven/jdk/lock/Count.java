package com.steven.jdk.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Steven on 2017/5/25.
 */
public class Count {
    final ReentrantLock lock = new ReentrantLock();

    public void get(){
        try{
            lock.lock(); // 加锁
            System. out.println(Thread.currentThread().getName() + "get begin");

            Thread. sleep(1000L);// 模仿干活

            System. out.println(Thread.currentThread().getName() + "get end");

        }catch (InterruptedException  e){
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }

    public void put(){
        try{
            lock.lock(); // 加锁
            System. out.println(Thread.currentThread().getName() + "put begin");

            Thread. sleep(1000L);// 模仿干活

            System. out.println(Thread.currentThread().getName() + "put end");
        }catch (InterruptedException  e){
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }

}
