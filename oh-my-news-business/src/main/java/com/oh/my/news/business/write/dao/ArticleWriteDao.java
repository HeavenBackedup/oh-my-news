package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.Article;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface ArticleWriteDao {


    Integer insertArticleReturnId(Article article)throws Exception;

    void insertUARelReturnId(Integer userId,Integer articleId,Integer type,Float value)throws Exception;


    boolean ifOpDone(int userId,int articleId,int type)throws Exception;

    void updateMark(int id,float score)throws Exception;

    void updateReport(int id)throws Exception;

    void updateCollect(int id)throws Exception;

    void updateThumbUp(int id)throws Exception;


    void saveArticle(Article article)throws Exception;

    void publishArticle(Article article)throws Exception;


    void saveMedia(List<Integer> mediaIds,int articleId)throws Exception;

}
