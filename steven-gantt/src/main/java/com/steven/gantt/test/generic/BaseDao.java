package com.steven.gantt.test.generic;

/**
 * Created by Steven on 2017/4/19.
 */
public class BaseDao<T> {

    private T name;

    public BaseDao(){

    }

    public BaseDao(T name){
        this.name = name;
    }


    public T getDetail(){
        System.out.println("进入到T 方法 : "+name);
        return name;
    };

    public T getLength(T obj){
        return obj;
    }
}
