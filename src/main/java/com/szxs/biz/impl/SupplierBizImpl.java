package com.szxs.biz.impl;

import com.szxs.biz.SupplierBiz;
import com.szxs.dao.SupplierDao;
import com.szxs.entity.Supplier;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupplierBizImpl implements SupplierBiz {
     @Resource(name = "supplierDao")
     private SupplierDao supplierDao;
    public void querySupplierByPager(Pager<Supplier> pager) {
        pager.setTotalRows(selectByPagerCount(pager.getParams().getDname(),pager.getParams().getDid()));
        pager.setDatas(       supplierDao.querySupplierByPager(pager.getParams().getDname(),pager.getParams().getDid(),
                (pager.getPageNo()-1)*pager.getPageSize(),pager.getPageSize()));
    }

    public Supplier querySupplierById(int did) {
        return supplierDao.querySupplierById(did);
    }

    public int selectByPagerCount(String dname, int did) {
        return supplierDao.selectByPagerCount(dname,did);
    }

    public boolean saveSupplier(Supplier supplier) {
          return supplierDao.saveSupplier(supplier)>0;
    }

    public boolean modifySupplier(Supplier supplier) {
        return supplierDao.modifySupplier(supplier)>0;
    }

    public boolean deleteSupplier(int did) {
        return supplierDao.deleteSupplier(did)>0;
    }

    public boolean selectByName(String dname) {
        return supplierDao.selectByName(dname)>0;
    }

    public boolean selectByTel(String dtel) {
        return supplierDao.selectByTel(dtel)>0;
    }

    public boolean selectByEmail(String demail) {
        return supplierDao.selectByEmail(demail)>0;
    }

    public boolean selectpurchase_infoById(int did) {
        return supplierDao.selectpurchase_infoById(did)>0;
    }
}
