package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.vo.mainpage.EditContent;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface ArticleRecommendManage {


    List<ArticleSnapshot> getCollect()throws Exception;

    List<ArticleSnapshot> getMark()throws Exception;

    List<ArticleSnapshot> getLast()throws Exception;

    List<EditContent> getRecommendByCategoryId(int categoryId)throws Exception;
}
