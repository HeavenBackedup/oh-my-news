package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.Wallet;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.aspectj.weaver.ast.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/8.
 */
public class WalletReadDaoTestCase extends TestCase {
    private WalletReadDao walletReadDao;
    public WalletReadDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.walletReadDao=(WalletReadDao)applicationContext.getBean("walletReadDaoImpl");
    }

    public void testGetFigure(){
        float figure=0;
        try {
            figure=this.walletReadDao.getFigure(1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }


    }
    public void testGetMaxFigure(){
        float maxfigure=0;
        try {
            maxfigure=this.walletReadDao.getMaxFigure(1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }

    }





}
