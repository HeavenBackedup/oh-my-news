package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public class ConcernReadDaoTestCase extends TestCase {
    private ConcernReadDao concernReadDao;

    public ConcernReadDaoTestCase(){
//        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.concernReadDao=(ConcernReadDao)applicationContext.getBean("concernReadDaoImpl");
    }

    public void testQueryMyConcernById(){
        try{
            System.out.println(this.concernReadDao.queryMyConcernsById(3));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testQueryMyFansById(){
        try {
            System.out.println(this.concernReadDao.queryMyFansById(4));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public  void testCheckConcernRelById(){
        try {
            System.out.println(this.concernReadDao.checkConcernRelById(1,3));
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
