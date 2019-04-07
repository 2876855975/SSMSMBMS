package com.szxs.biz.impl;

import com.szxs.biz.SalesProjectBiz;
import com.szxs.dao.Sales_projectDao;
import com.szxs.entity.Sales_project;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("salesProjectBiz")
public class SalesProjectBizImpl implements SalesProjectBiz {
       @Resource(name = "sales_projectDao")
        private Sales_projectDao sales_projectDao;


/*
    public void querySalesProjectByPager(Pager<Sales_project> pager) {
         pager.setTotalRows(selectCount());
         pager.setDatas(sales_projectDao.querySalesProjectByPager((pager.getPageNo()-1)*pager.getPageSize(),pager.getPageSize()));
    }

    public int selectCount() {
        return sales_projectDao.selectCount();
    }
*/

    public void querySalesProjectBySalieId(Pager<Sales_project> pager) {
        pager.setTotalRows(selectCountBySaleId(pager.getParams().getSuperSaleInfo().getSaleid()));
        pager.setDatas(sales_projectDao.queryPagerBySaleid((pager.getPageNo()-1)*pager.getPageSize(),pager.getPageSize(),pager.getParams().getSuperSaleInfo().getSaleid()));
    }

    public int selectCountBySaleId(int saleid) {
        return sales_projectDao.selectCountBySaleid(saleid);
    }

    public boolean deleteSaleProjectBySaleid(int saleid) {
        return sales_projectDao.deleteSalesProjectBySalideId(saleid)>0;
    }
}
