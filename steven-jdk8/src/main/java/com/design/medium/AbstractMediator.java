package com.design.medium;

/**
 * Created by Steven on 2017/7/4.
 */
public abstract class AbstractMediator {

    protected Pruchase pruchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator(Pruchase pruchase, Sale sale, Stock stock){
        this.pruchase = pruchase;
        this.sale = sale;
        this.stock = stock;
    }

    //中介中最重要的方法叫做事件方法，处理多个对象之间的关系
    public abstract void execute(String str, Object... objs);

}
