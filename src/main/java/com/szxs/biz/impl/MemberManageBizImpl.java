package com.szxs.biz.impl;

import com.szxs.biz.MemberManageBiz;
import com.szxs.dao.Member_manageDao;
import com.szxs.entity.Member_manage;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberManageBiz")
public class MemberManageBizImpl implements MemberManageBiz {
    @Resource(name = "member_manageDao")
    private Member_manageDao member_manageDao;

    public Member_manage queryMember(int mid) {
        return member_manageDao.queryMember(mid);
    }

    public void queryMemberByPager(Pager<Member_manage> pager) {
         pager.setTotalRows(selectMemberCount(pager.getParams().getMname(),pager.getParams().getMgrade().getGid(),pager.getParams().getMid()));
         pager.setDatas(member_manageDao.queryMemberByPager(pager.getParams().getMname(),pager.getParams().getMgrade().getGid(),pager.getParams().getMid(),
                 pager.getPageSize(),(pager.getPageNo()-1)*pager.getPageSize()));
    }

    public int selectMemberCount(String mname, int gid,int mid) {
        return member_manageDao.selectMemberCount(mname,gid,mid);
    }

    public boolean InsertMember(Member_manage memberManage) {
        return member_manageDao.InsertMember(memberManage)>0;
    }

    public boolean modifyMember(Member_manage memberManage) {
        return member_manageDao.modifyMember(memberManage)>0;
    }

    public boolean deleteMember(int mid) {
        return member_manageDao.deleteMember(mid)>0;
    }

    public boolean existsMemberForeignKey(int mid) {
        return member_manageDao.existsMemberForeignKey(mid)>0;
    }
}
