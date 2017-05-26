package com.steven.patten.factory;

/**
 * 抽象创建人类工厂
 * Created by Steven on 2017/5/26.
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> c);

    public void test(){
        System.out.println("test 方法");
    }

}
