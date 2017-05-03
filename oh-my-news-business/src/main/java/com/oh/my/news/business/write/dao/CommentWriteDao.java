package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.Comment;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentWriteDao {

    Integer insertCommentReturnId(Comment comment)throws Exception;
}
