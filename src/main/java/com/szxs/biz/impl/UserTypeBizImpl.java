package com.szxs.biz.impl;

import com.szxs.biz.UserTypeBiz;
import com.szxs.dao.UserTypeDao;
import com.szxs.entity.UserType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserTypeBizImpl implements UserTypeBiz {
    @Resource
    private UserTypeDao userTypeDao;
    public List<UserType> getAllUserType() {
        return userTypeDao.getAllUserType();
    }
}
