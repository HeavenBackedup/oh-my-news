package com.oh.my.news.business.read.manage;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Prometheus on 2017/5/9.
 */
public class ArticleReadManageTestCase extends TestCase {
    private ArticleReadManage articleReadManage;

    public ArticleReadManageTestCase(){
        System.setProperty("global.config.path","D:\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.articleReadManage=(ArticleReadManage)applicationContext.getBean("articleReadManageImpl");

    }

    public void testGetHistoryArticles() throws Exception{
        System.out.println(this.articleReadManage.getHistoryArticles(2,1,10));
    }

    public void testGetCollectedArticles() throws Exception{
        System.out.println(this.articleReadManage.getCollectedArticles(2,1,10));
    }

    public void testGetDraftArticles() throws Exception{
        System.out.println(this.articleReadManage.getDraftArticles(2,1,10));
    }

    public void testSearch() throws Exception{
        System.out.println(this.articleReadManage.search("测试",1,10));
    }
}
