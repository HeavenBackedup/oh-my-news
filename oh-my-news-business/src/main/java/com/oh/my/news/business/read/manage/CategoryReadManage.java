package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.po.Category;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface CategoryReadManage {
    List<Category> getCategories()throws Exception;
}
