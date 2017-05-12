package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.po.ArticleReader;
import com.oh.my.news.model.po.Article;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface ArticleReadDao {

    Article getArticleById(int id)throws Exception;

    ArticleReader getArticleReaderById(Integer articleId, Integer userId)throws Exception;

    List<Article> getHistoryArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception;
    List<Article> getHistoryArticlesByUserId(int userId, int currentPage, int pageItemNum,int sortType)throws Exception;

    List<Article> getDraftArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception;

    List<Article> getCollectedArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception;
    List<Article> getCollectedArticlesByUserId(int userId, int currentPage, int pageItemNum,int sortType)throws Exception;

    Integer getHistoryArticlesCountByUserId(int userId)throws Exception;

    Integer getDraftArticlesCountByUserId(int userId)throws Exception;

    Integer getCollectedArticlesCountByUserId(int userId)throws Exception;


    Integer queryUserIdById(int id)throws Exception;

    List<ArticleSnapshot> queryArticlesByUserId(int userId) throws Exception;

}
