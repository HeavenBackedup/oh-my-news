package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/6.
 */
public class TransactionReadDaoTestCase extends TestCase {
    private TransactionReadDao transactionReadDao;
    public TransactionReadDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
       this.transactionReadDao=(TransactionReadDao)applicationContext.getBean("transactionReadDaoImpl");
    }
    public void testPayevents(){

        try {
            System.out.println(this.transactionReadDao.Payevents(2));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testIncomeevents(){

        try {
            System.out.println(this.transactionReadDao.Incomeevents(3));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }



}
