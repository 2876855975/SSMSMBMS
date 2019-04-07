package com.szxs.entity;

public class Member_grade {
    private int gid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    private  String mgrade;  //会员等级
    private  double mdiscount;//会员折扣率

    public String getMgrade() {
        return mgrade;
    }

    public void setMgrade(String mgrade) {
        this.mgrade = mgrade;
    }

    public double getMdiscount() {
        return mdiscount;
    }

    public void setMdiscount(double mdiscount) {
        this.mdiscount = mdiscount;
    }
}
