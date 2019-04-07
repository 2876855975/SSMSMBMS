package com.szxs.biz.impl;

import com.szxs.biz.GoodsInfoBiz;
import com.szxs.dao.Goods_infoDao;
import com.szxs.entity.Goods_info;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsInfoBizImpl implements GoodsInfoBiz {

       @Resource(name = "goods_infoDao")
       private Goods_infoDao goods_infoDao;

    public List<Goods_info> queryAllGoods() {
        return goods_infoDao.queryAllGoods();
    }

    public void queryGoodsInfoByPager(Pager<Goods_info> pager) {
            pager.setTotalRows(selectGoodsInfoCount(pager.getParams().getGname(),pager.getParams().getGid(),pager.getParams().getGcategroy().getId()));
            pager.setDatas(goods_infoDao.queryGoodsInfoByPager(5,(pager.getPageNo()-1)*pager.getPageSize(),pager.getParams().getGname()
            ,pager.getParams().getGid(),pager.getParams().getGcategroy().getId()));

    }

    public int selectGoodsInfoCount(String gname, int gid, int categoryId) {
        return goods_infoDao.selectGoodsInfoCount(gname,gid,categoryId);
    }

    public boolean deleteGoodsInfo(int gid) {
        return goods_infoDao.deleteGoodsInfo(gid)>0;
    }

    public boolean saveGoodsInfo(Goods_info goods_info) {
        return goods_infoDao.saveGoodsInfo(goods_info)>0;
    }

    public boolean modifyGoodsInfo(Goods_info goods_info) {
        return goods_infoDao.modifyGoodsInfo(goods_info)>0;
    }

    public Goods_info selectGoodsInfoById(int gid) {
        return goods_infoDao.selectGoodsInfoById(gid);
    }

    public int existsGoodsStock(int gid) {
        return goods_infoDao.existsGoodsStock(gid);
    }
}
