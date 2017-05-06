package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.vo.mainpage.EditContent;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public class ArticleRecommendDaoTestCase extends TestCase {
    private ArticleRecommendDao articleRecommendDao;
    public ArticleRecommendDaoTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.articleRecommendDao=(ArticleRecommendDao)applicationContext.getBean("articleRecommendDaoImpl");
    }

    //数据库查询收藏排行新闻列表测试代码
    public void testQueryCollectList(){
        try {
            System.out.println(this.articleRecommendDao.queryCollectList());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
    //数据库查询评论排行新闻列表测试代码
    public void testQueryMarkList(){
        try {
            System.out.println(this.articleRecommendDao.queryMarkList());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    //数据库查询最新动态新闻列表测试代码
    public void testQueryLastList(){
        try {
            System.out.println(this.articleRecommendDao.queryLastList());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    //数据库根据类别id查询新闻列表测试代码
    public void  testQueryRecommendByCategoryId(){
        try {
            System.out.println(this.articleRecommendDao.queryRecommendByCategoryId(1,1,2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
