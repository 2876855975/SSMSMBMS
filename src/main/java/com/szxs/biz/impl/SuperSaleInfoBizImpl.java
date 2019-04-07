package com.szxs.biz.impl;

import com.szxs.biz.SuperSaleInfoBiz;
import com.szxs.dao.Super_sale_infoDao;
import com.szxs.entity.Super_sale_info;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
@Service("super_sale_biz")
public class SuperSaleInfoBizImpl implements SuperSaleInfoBiz {
    @Resource(name = "supersaleinfoDao")
    private Super_sale_infoDao superSaleInfoDao;


    public void querySuperSaleInfoPager(Pager<Super_sale_info> pager) {
             pager.setTotalRows(querySuperSaleInfoCount(pager.getParams().getSdate(),pager.getParams().getMember_manage().getMid(),
                     pager.getParams().getUser_info().getSid(),pager.getParams().getSaleid()));
             pager.setDatas(superSaleInfoDao.querySuperSaleInfoPager(pager.getPageSize(),(pager.getPageNo()-1)*pager.getPageSize(),pager.getParams().getSdate(),
                     pager.getParams().getMember_manage().getMid(),pager.getParams().getUser_info().getSid(),pager.getParams().getSaleid()));
    }

    public int querySuperSaleInfoCount(Date sdate, int mid, int sid, int saleid) {
        return superSaleInfoDao.querySuperSaleInfoCount(sdate,mid,sid,saleid);
    }

    public boolean deleteSuperSaleInfoBySaleId(int saleid) {
        return superSaleInfoDao.deleteSuperSaleInfoBySaleid(saleid)>0;
    }
}
