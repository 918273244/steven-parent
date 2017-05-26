package com.steven.patten.factory;

/**
 * 黄种男性
 * Created by Steven on 2017/5/26.
 */
public class MaleYellowHuman extends YellowHuman{

    @Override
    public void getColor() {
        System.out.println("新方法color");
    }

    @Override
    public void getSex() {
        System.out.println("黄种人男性");
    }
}
