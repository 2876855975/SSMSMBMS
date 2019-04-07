package com.szxs.biz.impl;

import com.szxs.biz.MemberGradeBiz;
import com.szxs.dao.Member_gradeDao;
import com.szxs.entity.Member_grade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberGradeBiz")
public class MemberGradeBizImpl implements MemberGradeBiz {
    @Resource(name = "member_gradeDao")
    private Member_gradeDao member_gradeDao;

    public List<Member_grade> queryMemberGrades() {
        return member_gradeDao.queryMemberGrades();
    }

    public boolean insertMemberGrade(Member_grade member_grade) {
        return member_gradeDao.insertMemberGrade(member_grade)>0;
    }

    public boolean updateMemberGrade(Member_grade member_grade) {
        return member_gradeDao.updateMemberGrade(member_grade)>0;
    }

    public boolean deleteMemberGrade(Member_grade member_grade) {
        return member_gradeDao.deleteMemberGrade(member_grade)>0;
    }
}
