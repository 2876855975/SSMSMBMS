package com.szxs.util;

import java.util.List;

public class Pager<T> {
    /**
     * 当前页数
     */
    private int pageNo;
    /**
     * 每页行数
     */
    private int pageSize;//每页行数
    /**
     * 总行数
     */
    private int totalRows;//总行数
    /**
     * 总页数
     */
    private int totalPage;//总页数
    /**
     * 起始位置
     */
    private int qis;
    /**
     * 条件T参数
     */
    private T params;
    /**
     * 结果集T集合
     */
    private List<T> datas= null;

    public int getQis() {
        return qis;
    }

    public void setQis(int qis) {
        this.qis = qis;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPage() {
        return  (totalRows + pageSize -1) / pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
