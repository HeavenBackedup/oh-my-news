package com.oh.my.news.business.read.dao;
import com.oh.my.news.business.read.dao.impl.PrivateMsgReadDaoImpl;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/7.
 */
public class PrivateMsgReadDaoTestCase extends TestCase {

    private PrivateMsgReadDao privateMsgReadDao;
    public PrivateMsgReadDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.privateMsgReadDao=(PrivateMsgReadDao) applicationContext.getBean("privateMsgReadDaoImpl");

    }
    public void testqueryExMsg()

    {
        try {
            System.out.println(this.privateMsgReadDao.queryExMsg(2, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void testqueryPrivateMessage(){
        try {
            System.out.println(this.privateMsgReadDao.queryPrivateMessage(2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
