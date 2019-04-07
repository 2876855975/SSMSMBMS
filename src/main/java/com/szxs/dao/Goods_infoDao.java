package com.szxs.dao;

import com.szxs.entity.Goods_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goods_infoDao")
public interface Goods_infoDao {

    /**
     * 按条件查询分页显示集合
     * @param pageSize
     * @param pageNo
     * @param ganme
     * @param gid
     * @return
     */
      List<Goods_info> queryGoodsInfoByPager(@Param("pageSize")int pageSize, @Param("pageNo")int pageNo,@Param("gname")
              String ganme,@Param("gid")int gid,@Param("categoryId") int categoryId);


    /**
     * 分页显示数据总行数
     * @param gname
     * @param gid
     * @return
     */
    int selectGoodsInfoCount(@Param("gname")String gname,@Param("gid")int gid,@Param("categoryId")int categoryId);


    /**
     * 删除商品信息
     * @param gid
     * @return
     */
    int deleteGoodsInfo(int gid);

    /**
     * 保存商品信息
     * @param goods_info
     * @return
     */
    int saveGoodsInfo(Goods_info goods_info);


    /**
     * 修改商品信息
     * @param goods_info
     * @return
     */
    int modifyGoodsInfo(Goods_info goods_info);


    /**
     * 根据id查询商品信息
     * @param gid
     * @return
     */
    Goods_info selectGoodsInfoById(int gid);


    int existsGoodsStock(int gid);


    List<Goods_info> queryAllGoods();
}
