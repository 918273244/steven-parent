package com.steven.patten.factory;

/**
 * Created by Steven on 2017/5/26.
 */
public abstract class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白人");
    }

    @Override
    public void talk() {
        System.out.println("白人讲话");
    }
}
