package com.szxs.entity;

public class UserType {

      private int tid;

    public UserType(int tid) {
        this.tid=tid;
    }

    public UserType(){

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    private String tname;
}
