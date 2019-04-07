package com.szxs.dao;

import com.szxs.entity.UserType;

import java.util.List;

public interface UserTypeDao {

    /**
     * 查询所有用户类型
     * @return
     */
    List<UserType> getAllUserType();
}
