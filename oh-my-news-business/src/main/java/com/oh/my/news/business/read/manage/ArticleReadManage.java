package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticleDetail;
import com.oh.my.news.model.dto.ArticleDto;
import com.oh.my.news.model.dto.SortType;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleReadManage {
    /**
     *
     * @param userId
     * @param currentPage 当前页数
     * @param pageItemNum 一个页面可以容纳的文章个数
     * @return  返回历史文章列表
     * @throws Exception
     */
    ArticleDto getHistoryArticles(int userId,int currentPage,int pageItemNum)throws Exception;


    ArticleDto getHistoryArticles(int userId,int currentPage,int pageItemNum,SortType sortType)throws Exception;
    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return  返回收藏文章列表
     * @throws Exception
     */
    ArticleDto getCollectedArticles(int userId, int currentPage, int pageItemNum)throws Exception;

    ArticleDto getCollectedArticles(int userId, int currentPage, int pageItemNum,SortType sortType)throws Exception;


    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return 返回草稿箱内文章列表
     * @throws Exception
     */
    ArticleDto getDraftArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param articleId
     * @return 根据文章的id来返回文章的具体信息
     * @throws Exception
     */
    ArticleDetail getArticleDetail(int articleId,int userId)throws Exception;


    /**
     *
     * @param text 搜索关键词
     * @param currentPage 当前页数
     * @param pageItemNum 一张页面可以存放的文章个数
     * @return 根据关键词搜索的文章列表
     * @throws Exception
     */
    ArticleDto search(String text,int currentPage,int pageItemNum)throws Exception;





}
