package com.steven.patten.factory.dao;

import com.steven.patten.factory.Human;

/**
 * Created by Steven on 2017/5/26.
 */
public interface HumanFactory {
    //黄种人
    public Human createYelloHuman();

    //白种人
    public Human createWhiteHuman();

    //黑人
    public Human createBlackHuman();
}
