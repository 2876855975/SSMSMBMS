package com.szxs.controller;


import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.szxs.biz.GoodsCategoryBiz;
import com.szxs.biz.GoodsInfoBiz;
import com.szxs.entity.Goods_Category;
import com.szxs.entity.Goods_info;
import com.szxs.util.Pager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {


        @Resource
        private GoodsInfoBiz goodsInfoBiz;

        @Resource
        private GoodsCategoryBiz goodsCategoryBiz;
        @RequestMapping("/list")
        public String selectGoodsInfoPager(@RequestParam(required = false,defaultValue = "1")int pageIndex,
                                           String gname, @RequestParam(required = false,defaultValue = "0")int gid,
                                           @RequestParam(required = false,defaultValue = "0") int id, Model model){
            System.out.println(gname);
            Pager<Goods_info> pager=new Pager<Goods_info>();
            Goods_info goods_info=new Goods_info();
            goods_info.setGid(gid);
            goods_info.setGname(gname);
            Goods_Category category=new Goods_Category();
            category.setId(id);
            goods_info.setGcategroy(category);
            pager.setPageNo(pageIndex);
            pager.setParams(goods_info);
            pager.setPageSize(5);
            goodsInfoBiz.queryGoodsInfoByPager(pager);
            model.addAttribute("pager",pager);
            System.out.println(pager.getDatas().size());
            return "jsp/goodsList";
        }

        @RequestMapping("/toModifyGoodsInfo")
        public String toModifyGoodsInfo(int gid,Model model){
            Goods_info goods_info = goodsInfoBiz.selectGoodsInfoById(gid);
            model.addAttribute("goods",goods_info);
            model.addAttribute("categorys",goodsCategoryBiz.getAllCategory());
            return "jsp/goodsModify";
        }


         @RequestMapping("/doModifyGoodsInfo")
        public String doModifyGoodsInfo(Goods_info goods_info,Model model){
              Goods_info oldGoods=goodsInfoBiz.selectGoodsInfoById(goods_info.getGid());
              oldGoods.setGname(goods_info.getGname());
              oldGoods.getGcategroy().setId(goods_info.getGcategroy().getId());
              oldGoods.setGcost_price(goods_info.getGcost_price());
              oldGoods.setGpoints(goods_info.getGpoints());
              oldGoods.setGremark(goods_info.getGremark());
              oldGoods.setGunit(goods_info.getGunit());
              oldGoods.setGstock(goods_info.getGstock());
              if(goodsInfoBiz.modifyGoodsInfo(oldGoods)){
                   return selectGoodsInfoPager(1,"",0,0,model);
              }else{
                   return toModifyGoodsInfo(goods_info.getGid(),model);
              }
        }


        @RequestMapping("/toaddGoodsInfo")
        public String toAddGoodsInfo(Model model){
            model.addAttribute("categorys",goodsCategoryBiz.getAllCategory());
            return "jsp/goodsAdd";
        }



        @RequestMapping("/doaddGoodsInfo")
        public String doaddGoddsInfo(Goods_info goods_info,Model model){
               if(goodsInfoBiz.saveGoodsInfo(goods_info)){
                   return selectGoodsInfoPager(1,"",0,0,model);
               }else{
                   return toAddGoodsInfo(model);
               }
        }

        @RequestMapping("/removeGoodsInfo")
        @ResponseBody
        public String deleteGoodsInfo(int gid){
            if(goodsInfoBiz.existsGoodsStock(gid)>0){
                return "0";
            }else{
                if(goodsInfoBiz.deleteGoodsInfo(gid)){
                    return "1";
                }else{
                    return "2";
                }
            }

        }






}
