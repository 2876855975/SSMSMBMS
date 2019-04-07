package com.szxs.controller;

import com.szxs.biz.SalesProjectBiz;
import com.szxs.entity.Sales_project;
import com.szxs.entity.Super_sale_info;
import com.szxs.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("sales")
public class SalesProjectController {
        @Resource(name = "salesProjectBiz")
        private SalesProjectBiz salesProjectBiz;

/*        @RequestMapping("/getPager")
      public String selectSalesProjectByPager(@RequestParam(required = false,defaultValue = "1")int pageIndex, Model model){
          Pager<Sales_project> pager=new Pager<Sales_project>();
          pager.setPageNo(pageIndex);
          pager.setPageSize(5);
          salesProjectBiz.querySalesProjectByPager(pager);
          model.addAttribute("pager",pager);
           return "jsp/salesProjectList";
      }*/

    @RequestMapping("/getPagerBySaleid")
    public String selectSalesProjectBySalied(@RequestParam(required = false,defaultValue = "1")int pageIndex,@RequestParam(required = false,defaultValue = "0")int saleid,
                                             Model model){
        Pager<Sales_project> pager=new Pager<Sales_project>();
        pager.setPageNo(pageIndex);
        Sales_project sales_project= new Sales_project();
        Super_sale_info super_sale_info=new Super_sale_info();
        super_sale_info.setSaleid(saleid);
        sales_project.setSuperSaleInfo(super_sale_info);
        pager.setParams(sales_project);
        pager.setPageSize(5);
        salesProjectBiz.querySalesProjectBySalieId(pager);
        System.out.println(pager.getDatas().size());
        model.addAttribute("pager",pager);
        return "jsp/salesProjectList";
    }
}
