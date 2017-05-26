package com.steven.jdk.worker2;

/**
 * 定义苹果消费者
 * Created by Steven on 2017/5/26.
 */
public class Consumer implements Runnable {

    private String instance;
    private Basket basket;

    public Consumer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    @Override
    public void run() {

            try {
                while (true){
                    // 消费苹果
                    System.out.println("消费者准备消费苹果：" + instance);
                    System.out.println(basket.consume());
                    System.out.println("!消费者消费苹果完毕：" + instance);
                    // 休眠1000ms
                Thread.sleep(1000);
        }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Consumer Interrupted");
            }
    }
}
