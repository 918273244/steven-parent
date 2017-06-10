package com.steven.netty.common.entity;

import java.io.Serializable;

/**
 * 解码对象
 * Created by Steven on 2017/6/10.
 */
public class Person implements Serializable {
    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + " sex:" + sex + " age:" + age;
    }
}
