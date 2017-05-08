package com.oh.my.news.business.write.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/6.
 */

public class TransactionWriteDaoTestCase extends TestCase{
    private TransactionWriteDao transactionWriteDao;
    public TransactionWriteDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.transactionWriteDao = (TransactionWriteDao) applicationContext.getBean("transactionWriteDaoImpl");
    }
    public void testInsertTransactionByIds(){


        try {
            this.transactionWriteDao.insertTransactionByIds(1, 2, 100, 4, String.valueOf(2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }



    }

    }








