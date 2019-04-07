package com.szxs.controller;

import com.szxs.biz.SalesProjectBiz;
import com.szxs.biz.SuperSaleInfoBiz;
import com.szxs.entity.Member_manage;
import com.szxs.entity.Super_sale_info;
import com.szxs.entity.User_info;
import com.szxs.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("supersaleinfo")
public class SupleSaleInfoController {
     @Resource(name = "super_sale_biz")
     private SuperSaleInfoBiz superSaleInfoBiz;
     @Resource
     private SalesProjectBiz salesProjectBiz;

     @RequestMapping("/getPager")
    public String selectSuperSaleInfoByPager(@RequestParam(required = false,defaultValue = "1")int pageIndex, @RequestParam(required = false) Date sDate, @RequestParam(required = false,defaultValue = "0") int mid,
                                             @RequestParam(required = false,defaultValue = "0")int sid, @RequestParam(required = false,defaultValue = "0")int saleid, Model model){
        Pager<Super_sale_info> pager=new Pager<Super_sale_info>();
        pager.setPageNo(pageIndex);
         System.out.println(pager.getPageNo());
        pager.setPageSize(5);
        Super_sale_info super_sale_info=new Super_sale_info();
        super_sale_info.setSaleid(saleid);
        super_sale_info.setMember_manage(new Member_manage(mid));
        super_sale_info.setUser_info(new User_info(sid));
        super_sale_info.setSdate(sDate);
        pager.setParams(super_sale_info);
        superSaleInfoBiz.querySuperSaleInfoPager(pager);
         System.out.println(pager.getDatas().size());
        model.addAttribute("pager",pager);
        return "jsp/supersaleinfoList";
    }



    @RequestMapping("/removeBySaleId")
    @ResponseBody
    public String removeBySaleId(int saleid){
          if(salesProjectBiz.deleteSaleProjectBySaleid(saleid) && superSaleInfoBiz.deleteSuperSaleInfoBySaleId(saleid)){
                return "1";
          }else{
                return "0";
          }
    }
}
