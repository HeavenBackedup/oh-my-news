package com.oh.my.news.business.write.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/8.
 */
public class WalletWriteDaoTestCase extends TestCase {

    private WalletWriteDao walletWriteDao;

    public WalletWriteDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.walletWriteDao = (WalletWriteDao) applicationContext.getBean("walletWriteDaoImpl");
    }
    public Integer testinsertWalletByUserId() {
        int a = 0;
        try {
            a=this.walletWriteDao.insertWalletByUserId(2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
        return a;

    }
    public void testupdateWalletFigure(){
        try {
            this.walletWriteDao.updateWalletFigure(2,200);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }


    }
   public void testsetWalletMaxFigure(){


       try {
           this.walletWriteDao.setWalletMaxFigure(2);
       } catch (Exception e) {
           e.printStackTrace();
           Assert.fail();
       }


   }




}
