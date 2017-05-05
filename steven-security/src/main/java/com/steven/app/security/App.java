package com.steven.app.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动
 * Created by Steven on 2017/4/12.
 */
@ComponentScan(basePackages={"com.steven.common"})
@MapperScan("com.steven.common.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
