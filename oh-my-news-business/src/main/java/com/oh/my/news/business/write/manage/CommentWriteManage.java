package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentWriteManage {


    void writeComment(int userId,int formerCommentId,int articleId,String content)throws Exception;
}
