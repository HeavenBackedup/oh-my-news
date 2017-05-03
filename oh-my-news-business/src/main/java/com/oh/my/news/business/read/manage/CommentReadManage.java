package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.CommentDto;
import com.oh.my.news.model.dto.CommentPageDto;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentReadManage {
    CommentPageDto getComments(int articleId, int currentPage, int pageItemNum)throws Exception;



}
