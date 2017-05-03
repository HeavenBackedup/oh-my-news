package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.po.Category;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
public interface CategoryReadDao {
    List<Category> queryAllCategories() throws Exception;
}
