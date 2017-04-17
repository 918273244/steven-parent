package com.steven.gantt.entity;


import java.sql.Timestamp;

/**
 * Created by Steven on 2017/3/23.
 */
public class RmtSys {

    private String id;
    private String rmtName;
    private Timestamp createTime;
    private boolean deleteStatus;//1：删除   0：未删除
    private Timestamp updateTime;
    private boolean typeFlag;//1：表示路标  0：解决方案

    public boolean getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.typeFlag = typeFlag;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRmtName() {
        return rmtName;
    }

    public void setRmtName(String rmtName) {
        this.rmtName = rmtName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }



}
