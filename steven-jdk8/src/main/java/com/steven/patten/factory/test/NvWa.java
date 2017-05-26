package com.steven.patten.factory.test;

import com.steven.patten.factory.Human;
import com.steven.patten.factory.YellowHuman;
import com.steven.patten.factory.dao.HumanFactory;
import com.steven.patten.factory.dao.impl.FemaleFactory;
import com.steven.patten.factory.dao.impl.MaleFactory;

/**
 * Created by Steven on 2017/5/26.
 */
public class NvWa {

    public static void main(String[] args) {
        //第一条生产线,男性生产线
        HumanFactory factory = new MaleFactory();

        //女性生产线
        HumanFactory yfactory = new FemaleFactory();

        //生产完毕  男人
        Human myello = factory.createYelloHuman();
        //女人
        Human fyello = yfactory.createYelloHuman();
        myello.getSex();
        myello.getColor();
        myello.talk();
        fyello.getSex();
        fyello.getColor();
        fyello.talk();
    }

}
