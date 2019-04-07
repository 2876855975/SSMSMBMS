package com.szxs.biz.impl;

import com.szxs.biz.GoodsCategoryBiz;
import com.szxs.dao.Goods_CategoryDao;
import com.szxs.entity.Goods_Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("categoryBiz")
public class GoodsCategoryBizImpl implements GoodsCategoryBiz {
    @Resource(name = "goods_category")
    private Goods_CategoryDao goods_categoryDao;

    public List<Goods_Category> getAllCategory() {
        return goods_categoryDao.getAllCategory();
    }
}
