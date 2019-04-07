package com.szxs.controller;

import com.alibaba.fastjson.JSON;
import com.szxs.biz.MemberGradeBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/mgrade")
public class MemberGradeController {
      @Resource(name="memberGradeBiz")
     private MemberGradeBiz memberGradeBiz;

      @RequestMapping("/getmembergradejson")
      @ResponseBody
      public String getMemberGradeJson(){
          System.out.println(memberGradeBiz.queryMemberGrades().get(0).getMgrade());
          return JSON.toJSONString(memberGradeBiz.queryMemberGrades());
      }
}
