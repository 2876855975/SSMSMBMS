package com.szxs.biz;

import com.szxs.entity.Sales_project;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SalesProjectBiz {

    /**
     * 分页查询销售项目集合
     * @param pager
     * @return
     */
/*    void querySalesProjectByPager(Pager<Sales_project> pager);*/


    /**
     * 查询分页数据行数
     * @return
     */
/*    int selectCount();*/

    void querySalesProjectBySalieId(Pager<Sales_project> pager);


    /**
     * 查询分页数据行数
     * @return
     */
    int selectCountBySaleId(int saleid);



    boolean deleteSaleProjectBySaleid(int saleid);
}
