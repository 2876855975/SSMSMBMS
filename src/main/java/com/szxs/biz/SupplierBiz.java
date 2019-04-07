package com.szxs.biz;

import com.szxs.entity.Supplier;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierBiz {


    /**
     *查询Supplier对象的集合属性
     * @param pager
     */
    void querySupplierByPager(Pager<Supplier> pager);

    /**
     * 按供应商id查询供应商对象
     * @param did
     * @return
     */
    Supplier querySupplierById(int did);


    /**
     * 按条件查询数据集合行数
     * @param dname
     * @param did
     * @return
     */
    int selectByPagerCount(String dname,int did);


    /**
     * 新增供应商对象
     * @param supplier
     * @return
     */
    boolean saveSupplier(Supplier supplier);


    /**
     * 修改供应商信息
     * @param supplier
     * @return
     */
    boolean modifySupplier(Supplier supplier);


    /**
     * 删除供应商对象
     * @param did
     * @return
     */
    boolean deleteSupplier(int did);




    /**
     * 查询是否有同名供应商
     * @param dname
     * @return
     */
    boolean selectByName(String dname);


    /**
     * 查询是否有同一联系方式供应商
     * @param dtel
     * @return
     */
    boolean selectByTel(String dtel);


    /**
     * 查询是否有同一邮箱
     * @param demail
     * @return
     */
    boolean selectByEmail(String demail);



    boolean selectpurchase_infoById(int did);



}
