package com.szxs.controller;

import com.alibaba.fastjson.JSON;
import com.szxs.biz.GoodsCategoryBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/categroy")
public class CategroyController {

    @Resource
    private GoodsCategoryBiz goodsCategoryBiz;

    @RequestMapping("/getcategoryjson")
    @ResponseBody
    public String getAllCategroyJsonString(){
           return JSON.toJSONString(goodsCategoryBiz.getAllCategory());
    }
}
