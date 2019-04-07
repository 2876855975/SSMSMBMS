package com.szxs.biz;

import com.szxs.entity.Goods_info;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsInfoBiz {




    List<Goods_info> queryAllGoods();

    /**
     *    按条件查询分页显示集合
     * @param pager
     */
    void queryGoodsInfoByPager(Pager<Goods_info> pager);


    /**
     * 分页显示数据总行数
     * @param gname
     * @param gid
     * @return
     */
    int selectGoodsInfoCount(String gname,int gid,int categoryId);


    /**
     * 删除商品信息
     * @param gid
     * @return
     */
    boolean deleteGoodsInfo(int gid);

    /**
     * 保存商品信息
     * @param goods_info
     * @return
     */
    boolean saveGoodsInfo(Goods_info goods_info);


    /**
     * 修改商品信息
     * @param goods_info
     * @return
     */
    boolean modifyGoodsInfo(Goods_info goods_info);


    /**
     * 根据id查询商品信息
     * @param gid
     * @return
     */
    Goods_info selectGoodsInfoById(int gid);


    int existsGoodsStock(int gid);
}
