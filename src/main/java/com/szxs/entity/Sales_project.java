package com.szxs.entity;
//销售项目

public class Sales_project {


    public Super_sale_info getSuperSaleInfo() {
        return superSaleInfo;
    }

    public void setSuperSaleInfo(Super_sale_info superSaleInfo) {
        this.superSaleInfo = superSaleInfo;
    }

    public Goods_info getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(Goods_info goods_info) {
        this.goods_info = goods_info;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    private  Super_sale_info superSaleInfo;
    private  Goods_info goods_info;
    private  int snum;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
