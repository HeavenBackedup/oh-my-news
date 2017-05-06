package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.po.Category;

import java.util.List;

/**
 * Created by Dzhaoooo on 2017/5/1.
 */
public interface CategoryReadManage {
    /**
     *
     * @return 返回所有类别信息
     * @throws Exception
     */
    List<Category> getCategories()throws Exception;
}
