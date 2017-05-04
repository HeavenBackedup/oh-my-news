package com.oh.my.news.business.write.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public class ConcernWriteDaoTestCase extends TestCase {
    private ConcernWriteDao concernWriteDao;

    public ConcernWriteDaoTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.concernWriteDao=(ConcernWriteDao)applicationContext.getBean("concernWriteDaoImpl");

    }

    public void testDeleteConcernByIds(){
        try{
            this.concernWriteDao.deleteConcernByIds(1,3);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testInsertConcernByIds(){
        try {
            this.concernWriteDao.insertConcernByIds(1,4);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
