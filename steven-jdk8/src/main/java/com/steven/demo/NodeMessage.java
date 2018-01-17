package com.steven.demo;

import java.io.Serializable;

/**
 * Created by Steven on 2017/6/15.
 */
public class NodeMessage<E extends Serializable> implements Serializable{

    private String message;
    private String nodeName;
    private E content;


    public void add(E content){
        System.out.println("add : "+content);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "me: "+message+" name: "+nodeName+" E: "+content;
    }
}
