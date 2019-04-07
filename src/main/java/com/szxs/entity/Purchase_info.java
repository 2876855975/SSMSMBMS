package com.szxs.entity;

import java.util.Date;

//采购信息
public class Purchase_info {
    private  int pid;      //采购单号
    private Date pdate;    //采购时间
    private Supplier supplier;      //供应商id 外键
    private  User_info user_info;     //操作用户id   外键

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public User_info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_info user_info) {
        this.user_info = user_info;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private  String remark;//采购备注
}
