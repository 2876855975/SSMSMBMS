package com.szxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//超市销售信息
public class Super_sale_info {

    private  int saleid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;
    private User_info user_info;
    public User_info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_info user_info) {
        this.user_info = user_info;
    }

    public Member_manage getMember_manage() {
        return member_manage;
    }

    public void setMember_manage(Member_manage member_manage) {
        this.member_manage = member_manage;
    }



    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }



    public double getMgeathering() {
        return mgeathering;
    }

    public void setMgeathering(double mgeathering) {
        this.mgeathering = mgeathering;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private  Member_manage member_manage;
    private  double mgeathering;
    private  double change;
    private  String remark;

}
