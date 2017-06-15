package com.steven.mapdb;

import java.io.Serializable;

/**
 * Created by Steven on 2017/6/15.
 */
public class Node<E> implements Serializable {

    // 队列中序号
    private long seq;

    // 队列中真实内容
    private E content;


    public Node(){

    }

    public Node(long seq, E content){
        this.seq = seq;
        this.content = content;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }
}
