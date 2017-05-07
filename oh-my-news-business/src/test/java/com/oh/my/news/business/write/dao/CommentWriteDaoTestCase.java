package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.vo.detail.Comment;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
public class CommentWriteDaoTestCase extends TestCase {
    private CommentWriteDao commentWriteDao;

    public CommentWriteDaoTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.commentWriteDao=(CommentWriteDao)applicationContext.getBean("commentWriteDaoImpl");

    }

    public void testInsertCommentReturnId(){
        try {
            com.oh.my.news.model.po.Comment comment=new com.oh.my.news.model.po.Comment();
            comment.setUserId(2);
            comment.setFormerCommentId(28);
            comment.setArticleId(2);
            comment.setContent("这是第二篇新闻的第一条根评论下的子评论");
            comment.setRootCommentId(28);
            commentWriteDao.insertCommentReturnId(comment);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public  void testUpdateRootCommentId(){
        try {
            commentWriteDao.updateRootCommentId(44);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
