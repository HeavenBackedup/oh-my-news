package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by llf on 2017/5/6.
 */
public class UserReadDaoTestCase extends TestCase {
    private UserReadDao userReadDao;

    public UserReadDaoTestCase() {
        System.setProperty("global.config.path","D:/gitcode/env/env-dev");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.userReadDao = (UserReadDao) applicationContext.getBean("userReadDaoImpl");
    }
    public void testVerifyUserbyuername(){
        try {
            System.out.println(this.userReadDao.verifyUserbyuername("llf3"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testVerifyUserbyemail(){
        try {
            System.out.println(this.userReadDao.verifyUserbyemail("123@qq.com"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testQueryUserbyusername(){
        try {
            System.out.println(this.userReadDao.queryUserbyusername("dongzhao","12345"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testQueryUserbyemail(){
        try {
            System.out.println(this.userReadDao.queryUserbyemail("123@qq.com","12345"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testQueryUserDetail(){
        try {
            System.out.println(this.userReadDao.queryUserDetail(1));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
