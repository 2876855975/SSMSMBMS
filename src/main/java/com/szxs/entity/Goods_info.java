package com.szxs.entity;

public class Goods_info {
    private int gid;  //商品编码
    private  String gname; //商品名
    private  float gcost_price;  //成本价
    private  int gstock;  //库存数量
    private float gprice;//售价
    private float gdiscount;//折扣率



    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public float getGcost_price() {
        return gcost_price;
    }

    public void setGcost_price(float gcost_price) {
        this.gcost_price = gcost_price;
    }

    public int getGstock() {
        return gstock;
    }

    public void setGstock(int gstock) {
        this.gstock = gstock;
    }

    public float getGprice() {
        return gprice;
    }

    public void setGprice(float gprice) {
        this.gprice = gprice;
    }

    public float getGdiscount() {
        return gdiscount;
    }

    public void setGdiscount(float gdiscount) {
        this.gdiscount = gdiscount;
    }

    public Goods_Category getGcategroy() {
        return gcategroy;
    }

    public void setGcategroy(Goods_Category gcategroy) {
        this.gcategroy = gcategroy;
    }

    public int getGpoints() {
        return gpoints;
    }

    public void setGpoints(int gpoints) {
        this.gpoints = gpoints;
    }

    public String getGunit() {
        return gunit;
    }

    public void setGunit(String gunit) {
        this.gunit = gunit;
    }

    public String getGremark() {
        return gremark;
    }

    public void setGremark(String gremark) {
        this.gremark = gremark;
    }

    private  Goods_Category gcategroy;//类别
    private  int  gpoints;//单个积分
    private  String gunit;//单位
    private  String gremark;//备注

}
