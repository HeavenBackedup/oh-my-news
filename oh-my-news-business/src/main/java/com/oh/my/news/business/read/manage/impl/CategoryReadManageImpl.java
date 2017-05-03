package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.CategoryReadDao;
import com.oh.my.news.business.read.manage.CategoryReadManage;
import com.oh.my.news.model.po.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
public class CategoryReadManageImpl implements CategoryReadManage {
    @Autowired
    private CategoryReadDao categoryReadDao;
    public List<Category> getCategories() throws Exception{
       return categoryReadDao.queryAllCategories();
    }
}
