package com.szxs.dao;

import com.szxs.entity.Member_grade;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("member_gradeDao")
public interface Member_gradeDao {

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
    int insertMemberGrade(Member_grade member_grade);


    /**
     * 修改会员类型信息
     * @param member_grade
     * @return
     */
    int updateMemberGrade(Member_grade member_grade);


    /**
     * 删除会员类型信息
     * @param member_grade
     * @return
     */
    int deleteMemberGrade(Member_grade member_grade);


}
