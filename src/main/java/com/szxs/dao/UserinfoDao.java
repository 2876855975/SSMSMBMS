package com.szxs.dao;

import com.szxs.entity.User_info;
import com.szxs.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userinfoDao")
public interface UserinfoDao {


    /**
     * 按条件查询单个对象
     * @param user_info
     * @return
     */
    User_info queryUser(User_info user_info);



    List queryUserInfoByPager(@Param("sid") int sid,@Param("username")String username,@Param("tid")int tid,
                              @Param("pageSize")int pageSize,@Param("pageNo")int pageNo);


    /**
     *     按条件查询数据行数
     * @param uid
     * @param uname
     * @param tid
     * @return
     */
    int selectPagerCount(@Param("sid") int uid,@Param("username") String uname,@Param("tid") int tid);


    /**
     * 新增用户
     * @param user_info
     * @return
     */
    int saveUserInfo(User_info user_info);


    /**
     * 修改用户
     * @param user_info
     * @return
     */
    int modifyUserInfo(User_info user_info);


    /**
     * 删除用户
     * @param sid
     * @return
     */
    int deleteUserInfo(int sid);


    /**
     * 按照用户id查询单个用户信息
     * @param sid
     * @return
     */
    User_info queryUserBySid(int sid);


    int updateUser(User_info user_info);


    int existsUserName(String username);

    int validateUserPassword(@Param("sid") int sid,@Param("userpassword")String userpassword);
}
