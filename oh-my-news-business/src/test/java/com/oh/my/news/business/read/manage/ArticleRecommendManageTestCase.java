package com.oh.my.news.business.read.manage;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public class ArticleRecommendManageTestCase extends TestCase {
    private ArticleRecommendManage articleRecommendManage;

    public ArticleRecommendManageTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.articleRecommendManage=(ArticleRecommendManage)applicationContext.getBean("articleRecommendManageImpl");

    }

    public void testGetCollect(){
        try {

            Thread.sleep(5000);
            System.out.println(this.articleRecommendManage.getCollect());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testGetMark(){
        try {
            Thread.sleep(5000);
            System.out.println(this.articleRecommendManage.getMark());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testGetLast(){
        try {
            Thread.sleep(5000);
            System.out.println(this.articleRecommendManage.getLast());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testGetRecommendByCategoryId(){
        try {
            System.out.println(this.articleRecommendManage.getRecommendByCategoryId(2,1,1));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
