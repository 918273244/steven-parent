package com.steven.jdk.demo1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Steven on 2017/5/2.
 */
public class Test2 {


    public static void main(String[] args) {
        Test2.test2();
    }


    public static void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();


        new Thread(() -> System.out.println("in java8 lamda expression rocks !!")).start();
    }


    public static void test2(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);
    }
}
