package com.szxs.dao;

import com.szxs.entity.Sales_project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("sales_projectDao")
public interface Sales_projectDao {

    /**
     * 分页查询销售项目集合
     * @param pagerNo
     * @param pagerSize
     * @return
     */
/*      List<Sales_project> querySalesProjectByPager(@Param("pagerNo")int pagerNo,@Param("pagerSize")int pagerSize);


    *//**
     * 查询分页数据行数
     * @return
     *//*
    int selectCount();*/



    int selectCountBySaleid(@Param("saleid") int saleid);


    List<Sales_project>  queryPagerBySaleid(@Param("pagerNo")int pagerNo,@Param("pagerSize")int pagerSize,@Param("saleid")int saleid);


    /**
     * 删除
     * @param saleid
     * @return
     */
    int deleteSalesProjectBySalideId(int saleid);
}
