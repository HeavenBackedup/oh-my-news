package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentWriteManage {

    /**
     * 写评论
     * @param userId 写评论的用户id
     * @param formerCommentId  该评论的根评论id
     * @param articleId 所评论的文章id
     * @param content 具体评论内容
     * @throws Exception
     */
    void writeComment(int userId,int formerCommentId,int articleId,String content)throws Exception;
}
