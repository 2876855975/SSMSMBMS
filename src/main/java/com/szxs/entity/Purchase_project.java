package com.szxs.entity;

/*
采购项目
 */
public class Purchase_project {
    private int pid;//采购单号
    private Goods_info goods_info;//商品id  外键
    private int pnum;//商品数量

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Goods_info getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(Goods_info goods_info) {
        this.goods_info = goods_info;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
}
