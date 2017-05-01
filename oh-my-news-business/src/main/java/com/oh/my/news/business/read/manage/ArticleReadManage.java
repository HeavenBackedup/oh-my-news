package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.ArticleDto;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleReadManage {
    List<ArticleDto> getHistory(int userId,int currentPage,int pageItemNum)throws Exception;

}
