package com.szxs.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.szxs.biz.UserTypeBiz;
import com.szxs.biz.User_infoBiz;
import com.szxs.entity.UserType;
import com.szxs.entity.User_info;
import com.szxs.util.MD5Util;
import com.szxs.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserinfoController {

       @Resource
       private User_infoBiz user_infoBiz;

    @Resource
    private UserTypeBiz userTypeBiz;



    /**
     * 用户登录验证方法
     * @param userInfo
     * @param session
     * @param valideteCode
     * @param model
     * @return
     */
       @RequestMapping("/loginUser")
       public String loginUser(User_info userInfo, HttpSession session, String valideteCode, Model model){
           System.out.println(session.getAttribute("strCode"));
           System.out.println(valideteCode);
           System.out.println();
           if(session.getAttribute("strCode").equals(valideteCode)){
               User_info user_info = user_infoBiz.queryUser(userInfo);
               if(null!=user_info){
                     session.setAttribute("user",user_info);
                     return "jsp/frame";
               }else{
                     model.addAttribute("msg","用户名或密码错误");
                     return "login";
               }
           }else{
                     model.addAttribute("msg","验证码错误");
               return "login";
           }


       }


    /**
     * 分页显示数据集合
     * @param pageIndex
     * @param sid
     * @param username
     * @param model
     * @return
     */
       @RequestMapping("/user/list")
       public String selectUserInfoPager(@RequestParam(required = false,defaultValue = "1")int pageIndex,
                                         @RequestParam(required = false,defaultValue = "0")int sid,
                                         @RequestParam(required = false,defaultValue = "0") int tid,
                                          String username,Model model){
           Pager<User_info> pager=new Pager<User_info>();
           User_info user_info=new User_info();
           user_info.setUserType(new UserType(tid));
           user_info.setSid(sid);
           user_info.setUsername(username);
           pager.setPageNo(pageIndex);
           pager.setPageSize(5);
           pager.setParams(user_info);
           user_infoBiz.queryUserInfoByPager(pager);
           model.addAttribute("pager",pager);
           return "jsp/userList";
       }


    /**
     * 前往用户信息修改页面
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping("/user/toModifyUser")
       public String toModifyUserInfo(int sid,Model model){
              model.addAttribute("user",user_infoBiz.selectBySid(sid));
        List<UserType> allUserType = userTypeBiz.getAllUserType();
        System.out.println(allUserType.get(0).getTname());

        model.addAttribute("usertype",allUserType);
        return "jsp/userModify";
       }


    /**
     * 修改员工信息
     * @param user_info
     * @return
     */
       @RequestMapping("/user/doModifyUser")
       public String doModifyUser(User_info user_info,Model model){
            if(user_infoBiz.modifyUserInfo(user_info)){
                return selectUserInfoPager(1,0,0,"",model);
            }else{
                return toModifyUserInfo(user_info.getSid(),model);
            }
       }


    /**
     * 删除用户
     * @param sid
     * @return
     */
       @RequestMapping("/user/removeuser")
       @ResponseBody
       public String removeUser(int sid){
           if(user_infoBiz.deleteUserInfo(sid)){
                 return "1";
           }else{
                 return "0";
           }
       }


      @RequestMapping("/user/toaddUser")
       public String toaddUser(Model model){
           model.addAttribute("usertype",userTypeBiz.getAllUserType());
           return "jsp/userAdd";
       }


       @RequestMapping("/user/doaddUser")
       public String doaddUser(User_info user_info,Model model){
            if(user_infoBiz.saveUserInfo(user_info)){
                 return selectUserInfoPager(1,0,0,"",model);
            }else{
                  return toaddUser(model);
            }
       }


       @RequestMapping("/user/existsUser")
       @ResponseBody
       public String existsUser(String username){
           if(user_infoBiz.existsUserName(username)){
               return "0";
           }else{
               return "1";
           }
       }

        @RequestMapping("/user/validateUserPassword")
        @ResponseBody
       public String validateUserPassword(int sid,String userpassword){
           if(user_infoBiz.validateUserPassword(sid, MD5Util.md5Password(userpassword))){
               return "0";
           }else{
               return "1";
           }
       }

      @RequestMapping("/user/tomodifyuserpassword")
       public String toModifySelfPassword(int sid,Model model){
                  model.addAttribute("sid",sid);
                  return "jsp/modifyuserpassword";
       }


       @RequestMapping("/user/domodifyUserPassword")
       public String modifyUserpassword(int sid, String userpassword, Model model){
           User_info user_info = user_infoBiz.selectBySid(sid);
           user_info.setUserpassword(userpassword);
           if(user_infoBiz.modifyUserInfo(user_info)){
               return "jsp/frame";
           }else{
               return toModifySelfPassword(sid,model);
           }
       }


       @RequestMapping("/user/loginout")
       public String loginOutUserInfo(HttpSession session){
           session.removeAttribute("user");
           session.invalidate();
           return  toLoginJSP();
       }

       public String toLoginJSP(){
           return "login";
       }








}
