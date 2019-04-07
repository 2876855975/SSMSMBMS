package com.szxs.dao;

import com.szxs.entity.Goods_Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("goods_category")
public interface Goods_CategoryDao {


       List<Goods_Category> getAllCategory();
}
