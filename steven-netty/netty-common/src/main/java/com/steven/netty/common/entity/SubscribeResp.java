package com.steven.netty.common.entity;

import java.io.Serializable;

/**
 * Created by Steven on 2017/6/10.
 */
public class SubscribeResp implements Serializable {

    private int nSubReqID;

    private int nRespCode;

    private String strDesc;

    public int getnSubReqID() {
        return nSubReqID;
    }

    public void setnSubReqID(int nSubReqID) {
        this.nSubReqID = nSubReqID;
    }

    public int getnRespCode() {
        return nRespCode;
    }

    public void setnRespCode(int nRespCode) {
        this.nRespCode = nRespCode;
    }

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    @Override
    public String toString() {
        return "SubscribeResp [nSubReqID=" + nSubReqID + ", nRespCode=" + nRespCode
                + ", strDesc=" + strDesc + "]";
    }
}
