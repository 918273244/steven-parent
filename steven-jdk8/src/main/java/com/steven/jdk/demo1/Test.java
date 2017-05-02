package com.steven.jdk.demo1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Steven on 2017/5/2.
 */
public class Test {


    public static void main(String[] args) {
       /* Formula formula = new Formula() {

            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }

        };


        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0
*/


        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
               return b.compareTo(a);
            }
        });

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });


        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        Collections.sort(names, (a, b) -> b.compareTo(a));

    }


    public void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();


        new Thread(() -> System.out.println("in java8 lamda expression rocks !!")).start();
    }


    public void test2(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
//        features.forEach(System.out::println);
    }
}
