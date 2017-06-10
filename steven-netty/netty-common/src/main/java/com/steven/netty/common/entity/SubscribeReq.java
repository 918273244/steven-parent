package com.steven.netty.common.entity;

import java.io.Serializable;

/**
 * Created by Steven on 2017/6/10.
 */
public class SubscribeReq implements Serializable {

    private int nSubReqID;
    private String strUserName;
    private String strProductName;

    private String strPhoneNumber;

    private String strAddr;


    public int getnSubReqID() {
        return nSubReqID;
    }

    public void setnSubReqID(int nSubReqID) {
        this.nSubReqID = nSubReqID;
    }

    public String getStrUserName() {
        return strUserName;
    }

    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    public String getStrProductName() {
        return strProductName;
    }

    public void setStrProductName(String strProductName) {
        this.strProductName = strProductName;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }

    public String getStrAddr() {
        return strAddr;
    }

    public void setStrAddr(String strAddr) {
        this.strAddr = strAddr;
    }

    @Override
    public String toString() {
        return "----SubscribeReq[subReqID="+ nSubReqID + ",userName="+ strUserName
                +",productName="+strProductName+",phoneNumber="+strPhoneNumber
                +",address"+strAddr+"]";
    }
}
