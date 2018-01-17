package com.steven.demo;

import java.io.Serializable;

/**
 * Created by Steven on 2017/6/15.
 */
public class Person implements Serializable {

    private String psersonName;
    private int age;

    public String getPsersonName() {
        return psersonName;
    }

    public void setPsersonName(String psersonName) {
        this.psersonName = psersonName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "personName: "+psersonName+" , age: "+age;
    }
}
