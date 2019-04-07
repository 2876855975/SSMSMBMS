package com.szxs.biz;

import com.szxs.entity.User_info;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_infoBiz {

    /**
     * 按条件查询单个对象
     * @param user_info
     * @return
     */
    User_info queryUser(User_info user_info);





    /**
     *   按条件分页查询数据集合
     * @param pager
     */
     void queryUserInfoByPager(Pager<User_info> pager);


    /**
     *     按条件查询数据行数
     * @param uid
     * @param uname
     * @param tid
     * @return
     */
    int selectPagerCount(int uid,String uname,int tid);


    /**
     * 新增用户
     * @param user_info
     * @return
     */
    boolean saveUserInfo(User_info user_info);


    /**
     * 修改用户
     * @param user_info
     * @return
     */
    boolean modifyUserInfo(User_info user_info);


    /**
     * 删除用户
     * @param sid
     * @return
     */
    boolean deleteUserInfo(int sid);



    /**
     * 按照用户id查询单个用户信息
     * @param sid
     * @return
     */
    User_info selectBySid(int sid);


    boolean updateUser(User_info user_info);


    boolean existsUserName(String username);


    boolean validateUserPassword( int sid,String userpassword);
}
