package com.steven.patten.factory;

/**
 * Created by Steven on 2017/5/26.
 */
public abstract class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑人");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话");
    }
}
