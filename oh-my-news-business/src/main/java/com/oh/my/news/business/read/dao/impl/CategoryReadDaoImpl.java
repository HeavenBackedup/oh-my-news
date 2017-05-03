package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.CategoryReadDao;
import com.oh.my.news.model.po.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
public class CategoryReadDaoImpl implements CategoryReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public List<Category> queryAllCategories() throws Exception{
        return (List<Category>) sqlMapClient.queryForList("category_sqlMap.query_all_categories");
    }
}
