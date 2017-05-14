package com.steven.netty.chat;

/**
 * 消息对象
 * Created by Steven on 2017/5/8.
 */
public class ChatMsg {

    private String sender;//发送者;
    public String msg;//消息

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
