package com.steven.jdk.worker2;

/**
 * 苹果生产者
 * Created by Steven on 2017/5/26.
 */
public class Producer implements Runnable{

    private String instance;
    private Basket basket;

    public Producer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }


    @Override
    public void run() {
        try {
            while (true){
                //生产苹果
                System.out.println("生产者准备生产苹果："+instance);
                    basket.produce();
                System.out.println("!生产者生产苹果完毕：" + instance);
                // 休眠300ms
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
