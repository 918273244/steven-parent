package org.agreement.model;

import java.io.Serializable;

/**
 *  通道管理实体对象（数据库对象）
 */
public class ClientEntity implements Serializable {

    // 状态常量
    public final static int INVALID = 0;  // 停用
    public final static int VALID = 1;  // 启用
    public final static int STOP = 2;  // 暂停(HTTP中使用，其余协议借用，表示连接不存// 在)


    public final static int ARREEMENT_CMPP20 = 1;   // CMPP协议2.0
    public final static int ARREEMENT_SMPG30 = 2;   // SMPG3.0
    public final static int ARREEMENT_SGIP12 = 3;   // SGIP1.2
    public final static int ARREEMENT_HTTP = 4;   //  HTTP
    public final static int ARREEMENT_CMPP30 = 6;   // CMPP3.0

    // 连接响应状态
    private String respStatus;

    // 0：未连接，不可用     1：有连接，可用
    private volatile Integer status = 3;



}
