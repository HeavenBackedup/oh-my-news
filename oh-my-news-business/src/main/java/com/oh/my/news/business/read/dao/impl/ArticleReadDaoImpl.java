package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.ArticleReadDao;
import com.oh.my.news.model.po.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/5/9.
 */
@Repository
public class ArticleReadDaoImpl implements ArticleReadDao {

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    @Override
    public Article getArticleById(int id) throws Exception {
        return null;
    }

    @Override
    public Integer queryUserIdById(int id) throws Exception {
        return (Integer) sqlMapClient.queryForObject("article_sqlMap.query_user_id_by_id",id);
    }
}
