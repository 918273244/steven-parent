package com.design.clone;

/**
 * Created by Steven on 2017/7/4.
 */
public class Client {
    public static void main(String[] args) {
        //产生一个对象
        Thing thing = new Thing();
        //克隆一个对象
        try {
            Thing cloneThing = (Thing)thing.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
