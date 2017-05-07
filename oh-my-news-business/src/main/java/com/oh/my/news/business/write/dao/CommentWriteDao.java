package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.Comment;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentWriteDao {
    /**
     *
     * @param comment
     * @return 返回插入评论的id
     * @throws Exception
     */

    Integer insertCommentReturnId(Comment comment)throws Exception;

    /**
     * 根据当前评论id更新rootCommentId（针对插入的评论为根评论的情况）
     * @param id 当前评论id
     * @throws Exception
     */

    void updateRootCommentId(Integer id) throws Exception;
}
