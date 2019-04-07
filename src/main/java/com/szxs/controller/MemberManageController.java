package com.szxs.controller;

import com.szxs.biz.MemberGradeBiz;
import com.szxs.biz.MemberManageBiz;
import com.szxs.entity.Member_grade;
import com.szxs.entity.Member_manage;
import com.szxs.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberManageController {
     @Resource(name = "memberManageBiz")
    private MemberManageBiz memberManageBiz;

     @Resource(name="memberGradeBiz")
     private MemberGradeBiz memberGradeBiz;


    /**
     * 根据条件分页查询数据发送到客服端
     * @param mname
     * @param gid
     * @param model
     * @param pageIndex
     * @return
     */
     @RequestMapping("/list")
    public String selectMemberManageList(@RequestParam(required = false,defaultValue = "0") int mid,
                                         String mname,@RequestParam(required = false,defaultValue = "0") int gid,@RequestParam(required = false,defaultValue = "1") int pageIndex,Model model){
         Pager<Member_manage> pager=new Pager<Member_manage>();
         Member_manage member_manage=new Member_manage();
         member_manage.setMname(mname);
         member_manage.setMid(mid);
         Member_grade grade=new Member_grade();
         grade.setGid(gid);
         member_manage.setMgrade(grade);
         pager.setParams(member_manage);
         pager.setPageNo(pageIndex);
         pager.setPageSize(5);
         memberManageBiz.queryMemberByPager(pager);
         model.addAttribute("pager",pager);
         return "jsp/memberList";
    }


    /**
     * 前往新增页面
     * @param model
     * @return
     */
    @RequestMapping("/toaddMember")
    public String toaddMember(Model model){
        List<Member_grade> member_grades = memberGradeBiz.queryMemberGrades();
        model.addAttribute("grades",member_grades);
        return "jsp/memberAdd";
    }


    /**
     * 修改会员信息
     * @param memberManage
     * @param model
     * @return
     * @throws IOException
     */
        @RequestMapping("/doaddMember")
    public String doaddMember(Member_manage memberManage,Model model)  {
            System.out.println(memberManage.getMaccount()+"--"+memberManage.getMgrade().getMgrade());
        if(memberManageBiz.InsertMember(memberManage)){
            return selectMemberManageList(0,"",0,1,model);
        }else{
            return "error";
        }

    }


    /**
     * 前往修改页面
     * @param mid
     * @param model
     * @return
     */
     @RequestMapping("/toModifyMember")
    public String toModifyMember(int mid,Model model){
            model.addAttribute("member",memberManageBiz.queryMember(mid));
            model.addAttribute("grades",memberGradeBiz.queryMemberGrades());
            return "jsp/memberModify";
    }


    /**
     * 修改会员信息
     * @param memberManage
     * @param model
     * @param resp
     * @return
     * @throws IOException
     */
    @RequestMapping("doModifyMember")
    public  String doModify(Member_manage memberManage,Model model,HttpServletResponse resp) throws IOException {
        Member_manage oldMember = memberManageBiz.queryMember(memberManage.getMid());
        oldMember.setMgrade(memberManage.getMgrade());
        oldMember.setMname(memberManage.getMname());
        oldMember.setMtel(memberManage.getMtel());
        oldMember.setMsex(memberManage.getMsex());
        if(memberManageBiz.modifyMember(oldMember)){
            return selectMemberManageList(0,"",0,1,model);
        }else{
            return toModifyMember(oldMember.getMid(),model);
        }

    }

    /**
     * 删除会员信息信息
     * @param mid
     * @return
     */
    @RequestMapping("/deleteMember/{mid}")
    @ResponseBody
    public String deleteMember(@PathVariable("mid") int mid)  {
        System.out.println(mid);

        if(memberManageBiz.existsMemberForeignKey(mid)){
             return "0";
        }else{
            if(memberManageBiz.deleteMember(mid)){
                return "1";
            }else{
                return "2";
            }
        }

    }





}
