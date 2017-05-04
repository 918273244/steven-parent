package com.steven.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * user Client
 * Created by Steven on 2017/5/3.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserClient {


    public static void main(String[] args) {

        SpringApplication.run(UserClient.class,args);
    }
}
