package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticleDto;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleReadManage {
    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return
     * @throws Exception
     */
    List<ArticleDto> getHistoryArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return
     * @throws Exception
     */
    List<ArticleDto> getCollectedArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return
     * @throws Exception
     */
    List<ArticleDto> getDraftArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param articleId
     * @return
     * @throws Exception
     */
    ArticleDto getArticleDetail(int articleId)throws Exception;

}
