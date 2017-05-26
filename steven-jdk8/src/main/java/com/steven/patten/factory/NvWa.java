package com.steven.patten.factory;

/**
 * Created by Steven on 2017/5/26.
 */
public class NvWa {

    public static void main(String[] args) {
        //声明工厂
        AbstractHumanFactory factory = new HumanFactory();
        //开始造人
        WhiteHuman white =  factory.createHuman(WhiteHuman.class);
       white.getColor();
       white.talk();

       //黄
        YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.talk();
        yellowHuman.getColor();

        //黑
        BlackHuman blackHuman = factory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

    }
}
