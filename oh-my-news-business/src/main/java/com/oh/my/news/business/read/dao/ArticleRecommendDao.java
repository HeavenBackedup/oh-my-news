package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.vo.mainpage.EditContent;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public interface ArticleRecommendDao {
    /**
     *
     * @return 返回根据收藏量排序后的新闻列表，包括文章的id跟标题
     * @throws Exception
     */
    List<ArticleSnapshot> queryCollectList()throws Exception;

    /**
     *
     * @return 返回根据评论数排序后的新闻列表，包括文章的id跟标题
     * @throws Exception
     */
    List<ArticleSnapshot> queryMarkList() throws Exception;

    /**
     *
     * @return 返回根据文章发表时间排序后的新闻列表，包括文章的id跟标题
     * @throws Exception
     */
    List<ArticleSnapshot> queryLastList() throws Exception;

    /**
     *
     * @param categoryId 新闻所属类别
     * @param currentPage 当前页数（由前台作为参数传入）
     * @param pageItemNum 每页可容纳的新闻个数（由前台作为参数传入）
     * @return 根据新闻所属的类别通过综合排序后返回的新闻列表
     * @throws Exception
     */
    List<EditContent> queryRecommendByCategoryId(int categoryId,int currentPage,int pageItemNum) throws Exception;
}
