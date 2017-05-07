package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.UserWrite;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by llf on 2017/5/6.
 */
public class UserWriteDaoTestCase extends TestCase {
    private UserWriteDao userWriteDao;

    public UserWriteDaoTestCase() {
        System.setProperty("global.config.path","D:/gitcode/env/env-dev");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.userWriteDao = (UserWriteDao) applicationContext.getBean("userWriteDaoImpl");
    }
    public void testInsertUser(){
        UserWrite user=new UserWrite();
        user.setUsername("llf");
        user.setEmail("1234567@qq.com");
        user.setPassword("123456");
        try {
            this.userWriteDao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testInsertSignature(){
        try {
            this.userWriteDao.insertSignature(1,"HAHA");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testInsertAnnouncement(){
        try {
            this.userWriteDao.insertAnnouncement(1,"haha");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testUpdateUser(){
        UserWrite user=new UserWrite();
        user.setId(1);
        user.setUsername("llf2");
        user.setPassword("1234567");
        user.setEmail("12390@qq.com");
        user.setMedia_id(2);
        user.setAddress("1,2,3");
        user.setAnnouncement("oainsd");
        user.setNickname("ikaudh");
        try {
            this.userWriteDao.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
