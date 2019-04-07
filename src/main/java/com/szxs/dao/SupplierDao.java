package com.szxs.dao;

import com.szxs.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("supplierDao")
public interface SupplierDao {
    /**
     * 查询供应商信息分页显示数据
     * @param dname
     * @param did
     * @param pageNo
     * @param pageSize
     * @return
     */
       List<Supplier>  querySupplierByPager(@Param("dname")String dname,@Param("did")int did,
                                            @Param("pageNo")int pageNo,@Param("pageSize")int pageSize);

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
    int selectByPagerCount(@Param("dname")String dname,@Param("did")int did);


    /**
     * 新增供应商对象
     * @param supplier
     * @return
     */
    int saveSupplier(Supplier supplier);


    /**
     * 修改供应商信息
     * @param supplier
     * @return
     */
    int modifySupplier(Supplier supplier);


    /**
     * 删除供应商对象
     * @param did
     * @return
     */
    int deleteSupplier(int did);


    /**
     * 查询是否有同名供应商
     * @param dname
     * @return
     */
    int selectByName(String dname);


    /**
     * 查询是否有同一联系方式供应商
     * @param dtel
     * @return
     */
    int selectByTel(String dtel);


    /**
     * 查询是否有同一邮箱
     * @param demail
     * @return
     */
    int selectByEmail(String demail);



    int selectpurchase_infoById(int did);
}
