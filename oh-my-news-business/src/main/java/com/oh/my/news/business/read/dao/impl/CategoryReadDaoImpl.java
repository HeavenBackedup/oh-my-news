package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.CategoryReadDao;
import com.oh.my.news.model.po.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
@Repository
public class CategoryReadDaoImpl implements CategoryReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public Category getCategoryById(int id)throws Exception{
        return (Category)sqlMapClient.queryForObject("category_sqlMap.query_category",id);
    }

    public List<Category> queryAllCategories() throws Exception{
        return (List<Category>) sqlMapClient.queryForList("category_sqlMap.query_all_categories");
    }
}
