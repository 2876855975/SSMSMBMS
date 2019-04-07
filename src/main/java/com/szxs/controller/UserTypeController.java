package com.szxs.controller;

import com.alibaba.fastjson.JSON;
import com.szxs.biz.UserTypeBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class UserTypeController {
     @Resource
    private UserTypeBiz userTypeBiz;


     @RequestMapping("/usertype/getall")
     @ResponseBody
     public String getJsonString(){
         return JSON.toJSONString(userTypeBiz.getAllUserType());
     }
}
