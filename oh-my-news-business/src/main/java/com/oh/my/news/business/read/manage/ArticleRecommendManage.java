package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.vo.mainpage.EditContent;

import java.util.List;

/**
 * Created by Dzhaoooo on 2017/5/3.
 */
public interface ArticleRecommendManage {

    /**
     *
     * @return 收藏排行的新闻list，包括文章的id跟topic
     * @throws Exception
     */
    List<ArticleSnapshot> getCollect()throws Exception;

    /**
     *
     * @return 评论排行的新闻list，包括文章的id跟topic
     * @throws Exception
     */

    List<ArticleSnapshot> getMark()throws Exception;

    /**
     *
     * @return 最新动态的新闻list，包括文章的id跟topic
     * @throws Exception
     */

    List<ArticleSnapshot> getLast()throws Exception;

    /**
     *
     * @param categoryId  新闻类型对应的id
     * @param currentPage  当前页数
     * @param pageItemNum  一页可容纳的新闻个数
     * @return  根据新闻类型返回对应的新闻列表
     * @throws Exception
     */

    List<EditContent> getRecommendByCategoryId(int categoryId,int currentPage,int pageItemNum)throws Exception;
}
