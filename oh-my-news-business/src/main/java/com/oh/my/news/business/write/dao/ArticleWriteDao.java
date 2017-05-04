package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.Article;

/**
 * Created by shj on 2017/5/3.
 */
public interface ArticleWriteDao {


    Integer insertArticleReturnId(Article article)throws Exception;


}
