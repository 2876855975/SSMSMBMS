package com.szxs.entity;

public class Member_manage {


    private  int mid;
    private  String mname;
    private  String msex;
    private  Member_grade mgrade;
    private  double mminetary;
    private String mtel;
    private double maccount;

    public Member_manage(int mid) {
        this.mid=mid;
    }

    public Member_manage(){}

    public double getMaccount() {
        return maccount;
    }

    public void setMaccount(double maccount) {
        this.maccount = maccount;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex;
    }

    public Member_grade getMgrade() {
        return mgrade;
    }

    public void setMgrade(Member_grade mgrade) {
        this.mgrade = mgrade;
    }

    public double getMminetary() {
        return mminetary;
    }

    public void setMminetary(double mminetary) {
        this.mminetary = mminetary;
    }
}
