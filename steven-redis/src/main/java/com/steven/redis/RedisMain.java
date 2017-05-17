package com.steven.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Steven on 2017/5/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.steven.redis")
@EnableCaching
@EnableScheduling
public class RedisMain {
    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class, args);
    }
}
