package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
public class CategoryReadDaoTestCase extends TestCase{
    private CategoryReadDao categoryReadDao;

    public CategoryReadDaoTestCase() {
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.categoryReadDao=(CategoryReadDao)applicationContext.getBean("categoryReadDaoImpl");

    }
    public void testQueryAllCategories() {
        try {
            System.out.println(this.categoryReadDao.queryAllCategories());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }


    }
}
