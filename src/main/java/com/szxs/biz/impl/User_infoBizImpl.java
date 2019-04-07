package com.szxs.biz.impl;

import com.szxs.biz.User_infoBiz;
import com.szxs.dao.UserinfoDao;
import com.szxs.entity.User_info;
import com.szxs.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class User_infoBizImpl implements User_infoBiz {

    @Resource(name = "userinfoDao")
     private UserinfoDao userinfoDao;


    /**
     * 查询单个对象
     * @param user_info
     * @return
     */
    public User_info queryUser(User_info user_info) {
        return userinfoDao.queryUser(user_info);
    }

    public void queryUserInfoByPager(Pager<User_info> pager) {
        pager.setTotalRows(selectPagerCount(pager.getParams().getSid(),pager.getParams().getUsername(),pager.getParams().getUserType().getTid()));
        pager.setDatas(userinfoDao.queryUserInfoByPager(pager.getParams().getSid(),pager.getParams().getUsername(),pager.getParams().getUserType().getTid(),
                pager.getPageSize(),(pager.getPageNo()-1)*pager.getPageSize()));
    }

    public int selectPagerCount(int uid, String uname, int tid) {
        return userinfoDao.selectPagerCount(uid,uname,tid);
    }


    public boolean saveUserInfo(User_info user_info) {
        return userinfoDao.saveUserInfo(user_info)>0;
    }

    public boolean modifyUserInfo(User_info user_info) {
        return userinfoDao.updateUser(user_info)>0;
    }

    public boolean deleteUserInfo(int sid) {
        return userinfoDao.deleteUserInfo(sid)>0;
    }

    public User_info selectBySid(int sid) {
        return userinfoDao.queryUserBySid(sid);
    }

    public boolean updateUser(User_info user_info) {
        return userinfoDao.updateUser(user_info)>0;
    }

    public boolean existsUserName(String username) {
        return userinfoDao.existsUserName(username)>0;
    }

    public boolean validateUserPassword(int sid, String userpassword) {
        return userinfoDao.validateUserPassword(sid,userpassword)>0;
    }


}
