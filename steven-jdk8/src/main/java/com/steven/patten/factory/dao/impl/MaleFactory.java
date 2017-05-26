package com.steven.patten.factory.dao.impl;

import com.steven.patten.factory.Human;
import com.steven.patten.factory.MaleYellowHuman;
import com.steven.patten.factory.dao.HumanFactory;

/**
 * Created by Steven on 2017/5/26.
 */
public class MaleFactory implements HumanFactory{
    @Override
    public Human createYelloHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return null;
    }

    @Override
    public Human createBlackHuman() {
        return null;
    }
}
