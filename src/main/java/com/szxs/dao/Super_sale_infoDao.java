package com.szxs.dao;

import com.szxs.entity.Super_sale_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository("supersaleinfoDao")
public interface Super_sale_infoDao {

    /**
     * 按条件分页查询销售信息集合
     * @param pageSize
     * @param pagerNo
     * @param sdate
     * @param mid
     * @param sid
     * @param saleid
     * @return
     */
    List<Super_sale_info> querySuperSaleInfoPager(@Param("pagerSize")int pageSize, @Param("pagerNo")int pagerNo,@Param("sdate") Date sdate,
                                                  @Param("mid")int mid,@Param("sid")int sid,@Param("saleid")int saleid);

    /**
     * 查询数据总行数
     * @param sdate
     * @param mid
     * @param sid
     * @param saleid
     * @return
     */
    int querySuperSaleInfoCount(@Param("sdate") Date sdate,
                                 @Param("mid")int mid,@Param("sid")int sid,@Param("saleid")int saleid);


    /**
     * 删除
     * @param saleid
     * @return
     */
    int deleteSuperSaleInfoBySaleid(int saleid);



}
