package com.steven.jdk.demo1;

/**
 * 给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，
 * Created by Steven on 2017/5/2.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        System.out.println("new: "+a);
        return Math.sqrt(a);
    }
}
