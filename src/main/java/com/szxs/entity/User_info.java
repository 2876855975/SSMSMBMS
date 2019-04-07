package com.szxs.entity;

import com.szxs.util.MD5Util;

public class User_info {
    private  int sid;//用户id
    private  String username;//用户名
    private  String userpassword;//用户密码
    private  UserType userType;//用户类型

    public User_info(int sid) {
        this.sid=sid;
    }
    public User_info(){}

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = MD5Util.md5Password(userpassword);
    }


}
