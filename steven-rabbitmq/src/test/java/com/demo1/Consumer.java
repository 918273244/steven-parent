package com.demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * Created by Steven on 2017/7/18.
 */
public class Consumer {

    private final static String QUEUE_NAME = "hello2";

    public static void main(String[] args) {
        /* 使用工厂类建立Connection和Channel，并且设置参数 */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.129");// MQ的IP
        factory.setPort(5672);// MQ端口
        factory.setUsername("admin");// MQ用户名
        factory.setPassword("admin123");// MQ密码

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            /* 声明要连接的队列 */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("等待消息产生：");

              /* 创建消费者对象，用于读取消息 */
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(QUEUE_NAME, true, consumer);

        /* 读取队列，并且阻塞，即在读到消息之前在这里阻塞，直到等到消息，完成消息的阅读后，继续阻塞循环 */
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("收到消息'" + message + "'");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
