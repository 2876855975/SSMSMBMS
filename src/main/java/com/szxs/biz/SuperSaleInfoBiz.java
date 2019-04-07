package com.szxs.biz;

import com.szxs.entity.Super_sale_info;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SuperSaleInfoBiz {


    /**
     * 按条件分页查询销售信息集合
     * pager
     *
     * @return
     */
    void querySuperSaleInfoPager(Pager<Super_sale_info> pager);

    /**
     * 查询数据总行数
     *
     * @param sdate
     * @param mid
     * @param sid
     * @param saleid
     * @return
     */
    int querySuperSaleInfoCount(Date sdate,
                                int mid, int sid, int saleid);


    boolean deleteSuperSaleInfoBySaleId(int saleid);

}