package com.szxs.dao;

import com.szxs.entity.Member_manage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("member_manageDao")
public interface Member_manageDao {

    /**
     * 根据会员id主键查询单个会员信息
     * @param mid
     * @return
     */
      Member_manage queryMember(int mid);

    /**
     * 按条件查询会员列表进行分页
     * @param pageSize
     * @param pageNo
     * @return
     */
      List<Member_manage> queryMemberByPager(@Param("mname") String mname,
                                             @Param("gid") int gid,@Param("mid")int mid,
                                             @Param("pageSize") int pageSize,@Param("pageNo") int pageNo);


    /**
     * 按条件查询分页数据行数
     * @param mname
     * @return
     */
      int selectMemberCount(@Param("mname")String mname,@Param("gid")int gid,@Param("mid")int mid);


    /**
     * 新增会员信息
     * @param memberManage
     * @return
     */
      int InsertMember(Member_manage memberManage);


    /**
     * 修改会员用户信息
     * @param memberManage
     * @return
     */
    int modifyMember(Member_manage memberManage);


    /**
     * 删除会员信息
     * @param mid
     * @return
     */
    int deleteMember(@Param("mid") int mid);




    int existsMemberForeignKey(int mid);



}
