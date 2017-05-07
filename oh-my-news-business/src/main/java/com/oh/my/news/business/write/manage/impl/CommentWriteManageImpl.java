package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.read.dao.CommentReadDao;
import com.oh.my.news.business.write.dao.CommentWriteDao;
import com.oh.my.news.business.write.manage.CommentWriteManage;
import com.oh.my.news.model.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
@Service
public class CommentWriteManageImpl implements CommentWriteManage {
    @Autowired
    private CommentWriteDao commentWriteDao;
    @Autowired
    private CommentReadDao commentReadDao;

    public void writeComment(int userId, int formerCommentId, int articleId, String content) throws Exception {
        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setArticleId(articleId);
        comment.setContent(content);
        int id;
        if(formerCommentId==0){
            comment.setFormerCommentId(0);
            id=commentWriteDao.insertCommentReturnId(comment);
            commentWriteDao.updateRootCommentId(id);

        }else{
            int articleid=commentReadDao.queryArticleIdByFormerCommentId(formerCommentId);
            if(articleid!=articleId){
                throw new Exception("the articleid is not match!!");
            }
            else{
                int rootCommentId=commentReadDao.queryRootCommentIdByFormerCommentId(formerCommentId);
                comment.setFormerCommentId(formerCommentId);
                comment.setRootCommentId(rootCommentId);
                commentWriteDao.insertCommentReturnId(comment);

            }

        }


    }
}
