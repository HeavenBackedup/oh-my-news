package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
public class CommentReadDaoTestCase extends TestCase {


    private CommentReadDao commentReadDao;

    public CommentReadDaoTestCase() {
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.commentReadDao=(CommentReadDao) applicationContext.getBean("commentReadDaoImpl");

    }

    public void testQueryCommentById(){
        try {
            System.out.print(commentReadDao.queryCommentById(23));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryCommentsByArticleId(){
        try {
            System.out.println(commentReadDao.queryCommentsByArticleId(2,1,10));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryRootCommentsByArticleId(){
        try {
            System.out.println(commentReadDao.queryRootCommentsByArticleId(1,1,10));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryCommentsByRootCommentId(){
        try {
            System.out.print(commentReadDao.queryCommentsByRootCommentId(22));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryPageNum(){
        try {
            System.out.print(commentReadDao.queryPageNum(1,2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryRootCommentIdByFormerCommentId(){
        try {
            System.out.println(commentReadDao.queryRootCommentIdByFormerCommentId(26));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQueryArticleIdByFormerCommentId(){
        try {
            System.out.println(commentReadDao.queryArticleIdByFormerCommentId(28));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
