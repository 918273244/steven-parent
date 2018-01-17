package com.design.clone;

/**
 * 原型模式
 * Created by Steven on 2017/7/4.
 */
public class Thing implements Cloneable{

    public Thing(){
        System.out.println("构造函数被执行");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Thing thing = null;
        try{
            thing = (Thing)super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return thing;
    }
}
