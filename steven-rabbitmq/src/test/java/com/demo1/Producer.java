package com.demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by Steven on 2017/7/18.
 */
public class Producer {

    private final static String QUEUE_NAME = "hello2";// 队列名不能重复 之前已有就会失败

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


            /* 创建消息队列，并且发送消息 */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "消息4";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("生产了个'" + message + "'");

        /* 关闭连接 */
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
