package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticalReader;
import com.oh.my.news.model.dto.ArticleDto;
import java.util.List;

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
    List<ArticleDto> getHistoryArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return  返回收藏文章列表
     * @throws Exception
     */
    List<ArticleDto> getCollectedArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param userId
     * @param currentPage
     * @param pageItemNum
     * @return 返回草稿箱内文章列表
     * @throws Exception
     */
    List<ArticleDto> getDraftArticles(int userId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param articleId
     * @return 根据文章的id来返回文章的具体信息
     * @throws Exception
     */
    ArticleDto getArticleDetail(int articleId)throws Exception;


    /**
     *
     * @param text 搜索关键词
     * @param currentPage 当前页数
     * @param pageItemNum 一张页面可以存放的文章个数
     * @return 根据关键词搜索的文章列表
     * @throws Exception
     */
    List<ArticleDto> search(String text,int currentPage,int pageItemNum)throws Exception;





}
