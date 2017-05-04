package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.po.Comment;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentReadDao {

    Comment getCommentByid(int id)throws Exception;



}
