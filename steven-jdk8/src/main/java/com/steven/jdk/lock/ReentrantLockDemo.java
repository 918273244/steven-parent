package com.steven.jdk.lock;

/**
 * Created by Steven on 2017/5/25.
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final Count count = new Count();
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
