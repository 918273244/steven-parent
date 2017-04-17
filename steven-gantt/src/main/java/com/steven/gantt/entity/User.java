package com.steven.gantt.entity;

import java.util.Date;
import java.util.List;

/**
 * 用户
 * Created by Steven on 2017/4/13.
 */
public class User  {
    /**
     * 序列化接口，自动生成序列号
     */
    private static final long serialVersionUID = -7741168269971132706L;

    private int userId;

    private String userName;

    private String userPassword;

    private String userNickname;

    private Date createTime;

    private Date lastUpdateTime;

    private String remark;

    private String status;

    private String authorityType;

    private String roleKey;

    private String role_id;

    private String mobile;
    private String email;

    private Long firstAreaId;
    private Long secondAreaId;

    private String role;

    private String deptName;


    private List<Roles> roles;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getFirstAreaId() {
        return firstAreaId;
    }

    public void setFirstAreaId(Long firstAreaId) {
        this.firstAreaId = firstAreaId;
    }

    public Long getSecondAreaId() {
        return secondAreaId;
    }

    public void setSecondAreaId(Long secondAreaId) {
        this.secondAreaId = secondAreaId;
    }

    public String getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    // 一个集合roles，初始容量为0
//	private Set<Roles> roles = new HashSet<Roles>(0);

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public User() {
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
