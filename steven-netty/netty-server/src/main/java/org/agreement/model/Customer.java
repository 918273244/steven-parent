package org.agreement.model;

import java.io.Serializable;

/**
 * 客户类
 */
public class Customer implements Serializable {

    private String spId;
    private String username;
    private String password;
    private String reportIp;
    private short version;
    private Integer status;
    private Integer speed = 300;
    private Integer type; // 行业类型
    private String wayNum; // 通道号

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReportIp() {
        return reportIp;
    }

    public void setReportIp(String reportIp) {
        this.reportIp = reportIp;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWayNum() {
        return wayNum;
    }

    public void setWayNum(String wayNum) {
        this.wayNum = wayNum;
    }
}
