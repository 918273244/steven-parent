package com.design.medium;

/**
 * Created by Steven on 2017/7/4.
 */
public class Mediator extends AbstractMediator {

    public Mediator(Pruchase pruchase, Sale sale, Stock stock) {
        super(pruchase, sale, stock);
    }

    @Override
    public void execute(String str, Object... objs) {

    }
}
