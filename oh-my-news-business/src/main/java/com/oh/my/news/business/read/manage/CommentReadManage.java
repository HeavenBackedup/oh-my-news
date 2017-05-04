package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.CommentDto;
import com.oh.my.news.model.dto.CommentPageDto;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentReadManage {
    /**
     *
     * @param articleId  该新闻的id
     * @param currentPage  当前页数
     * @param pageItemNum  一页可容纳的新闻个数
     * @return  返回该新闻对应的评论列表，包括根评论及其对应的子评论
     * @throws Exception
     */
    CommentPageDto getComments(int articleId, int currentPage, int pageItemNum)throws Exception;



}
