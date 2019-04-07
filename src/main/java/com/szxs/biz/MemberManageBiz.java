package com.szxs.biz;

import com.szxs.dao.Member_manageDao;
import com.szxs.entity.Member_manage;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public interface MemberManageBiz {

    /**
     * 根据会员id主键查询单个会员信息
     * @param mid
     * @return
     */
    Member_manage queryMember(int mid);


    /**
     * 修改页面对象
     * @param pager
     */
    void queryMemberByPager(Pager<Member_manage> pager);


    /**
     * 按条件查询分页数据行数
     * @param mname
     * @param gid
     * @return
     */
    int selectMemberCount(String mname, int gid,int mid);


    /**
     * 新增会员信息
     * @param memberManage
     * @return
     */
    boolean InsertMember(Member_manage memberManage);


    /**
     * 修改会员用户信息
     * @param memberManage
     * @return
     */
    boolean modifyMember(Member_manage memberManage);


    /**
     * 删除会员信息
     * @param mid
     * @return
     */
    boolean deleteMember(int mid);



    boolean existsMemberForeignKey(int mid);
}
