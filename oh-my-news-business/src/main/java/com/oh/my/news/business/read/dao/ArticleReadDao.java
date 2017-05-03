package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.po.Article;

/**
 * Created by shj on 2017/5/3.
 */
public interface ArticleReadDao {

    Article getArticleById(int id)throws Exception;



}
