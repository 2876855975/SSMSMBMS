package com.szxs.biz;

import com.szxs.entity.Member_grade;

import java.util.List;

public interface MemberGradeBiz {
    /**
     * 查询所有会员类型信息
     * @return
     */
    List<Member_grade> queryMemberGrades();


    /**
     * 新增会员类型信息
     * @param member_grade
     * @return
     */
    boolean insertMemberGrade(Member_grade member_grade);


    /**
     * 修改会员类型信息
     * @param member_grade
     * @return
     */
    boolean updateMemberGrade(Member_grade member_grade);


    /**
     * 删除会员类型信息
     * @param member_grade
     * @return
     */
    boolean deleteMemberGrade(Member_grade member_grade);
}
