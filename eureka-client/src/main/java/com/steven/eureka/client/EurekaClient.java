package com.steven.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * eureka客户端
 * Created by Steven on 2017/5/3.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClient {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient.class,args);
    }
}
