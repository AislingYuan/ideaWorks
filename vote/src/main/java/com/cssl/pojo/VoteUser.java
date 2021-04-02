package com.cssl.pojo;

import java.io.Serializable;

public class VoteUser implements Serializable {

    private int userId;//用户id
    private String userName;//用户名
    private String uPassword;//密码
    private int uStatus;//角色 管理员1 普通用户2

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

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getuStatus() {
        return uStatus;
    }

    public void setuStatus(int uStatus) {
        this.uStatus = uStatus;
    }

    public VoteUser() {
    }

    public VoteUser(int userId, String userName, String uPassword, int uStatus) {
        this.userId = userId;
        this.userName = userName;
        this.uPassword = uPassword;
        this.uStatus = uStatus;
    }

    @Override
    public String toString() {
        return "VoteUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uStatus=" + uStatus +
                '}';
    }
}
