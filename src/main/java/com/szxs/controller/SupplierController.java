package com.szxs.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.szxs.biz.SupplierBiz;
import com.szxs.entity.Supplier;
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

@Controller
@RequestMapping("/supplier")
public class SupplierController {

       @Resource
        private SupplierBiz supplierBiz;

    /**
     * 获取供应商分页数据
     * @param dname
     * @param did
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/list")
       public String selectSupplierByPager(String dname, @RequestParam(required = false,defaultValue = "0")int did,
                                           @RequestParam(required = false,defaultValue = "1") int pageIndex, Model model){
           Pager<Supplier> pager=new Pager<Supplier>();
           pager.setPageNo(pageIndex);
           Supplier supplier=new Supplier();
           supplier.setDname(dname);
           supplier.setDid(did);
           pager.setParams(supplier);
           pager.setPageSize(5);
           supplierBiz.querySupplierByPager(pager);
        System.out.println(pager.getDatas().size());
        model.addAttribute("pager",pager);
             return "jsp/supplierList";
       }



        @RequestMapping("/toModifySupplier")
       public String toModifySupplier(int did,Model model){
           Supplier supplier = supplierBiz.querySupplierById(did);
           model.addAttribute("supplier",supplier);
            System.out.println(supplier.getDname()+supplier.getDaddress()+supplier.getDemail());
           return "jsp/supplierModify";
       }


    /**
     * 修改供应商信息
     * @param supplier
     * @param model
     * @param resp
     * @return
     * @throws IOException
     */
    @RequestMapping("/doModifySupplier")
       public String doModifySupplier(Supplier supplier, Model model, HttpServletResponse resp) throws IOException {
           Supplier oldSupplier = supplierBiz.querySupplierById(supplier.getDid());
           oldSupplier.setDname(supplier.getDname());
           oldSupplier.setDaddress(supplier.getDaddress());
           oldSupplier.setDemail(supplier.getDemail());
           oldSupplier.setDtel(supplier.getDtel());
           if(supplierBiz.modifySupplier(oldSupplier)){
               return selectSupplierByPager("",0,1,model);
           }else{
               PrintWriter writer = resp.getWriter();
               return toModifySupplier(supplier.getDid(),model);
           }

       }


       @RequestMapping("/removeSupplier/{did}")
       @ResponseBody
       public String removeSupplier(@PathVariable("did") int did){
           System.out.println(did);
                if(supplierBiz.selectpurchase_infoById(did)){
                      return "0";
                }else{
                     if(supplierBiz.deleteSupplier(did)){
                         return "1";
                     }else{
                         return "2";
                     }
                }

       }

       @RequestMapping("/toAddSupplier")
       public String toaddSupplier(){
             return "jsp/supplierAdd";
       }


       @RequestMapping("/doaddSupplier")
       public String addSupplier(Supplier supplier,Model model){

           if(supplierBiz.saveSupplier(supplier)){
               return selectSupplierByPager("",0,1,model);
           }else{
               model.addAttribute("supplier",supplier);
               return "jsp/supplierAdd";
           }
       }

       @RequestMapping(value = "/existsName")
       @ResponseBody
       public String existName(String dname){
           System.out.println(dname);
            if(supplierBiz.selectByName(dname)){
                return "0";
            }else{
                return "1";
            }
       }


        @RequestMapping("/existsEmail")
        @ResponseBody
        public String existsEmail( String demail){
            System.out.println(demail);
            if(supplierBiz.selectByEmail(demail)){
                System.out.println(0);
                return "0";
            }else{
                System.out.println(1);
                return "1";
            }
        }




        @RequestMapping("/existsTel/{dtel}")
        @ResponseBody
        public String existsTel(@PathVariable("dtel") String dtel){
            System.out.println(dtel);
            if(supplierBiz.selectByTel(dtel)){
                return "0";
            }else{
                return "1";
            }
      }


}

