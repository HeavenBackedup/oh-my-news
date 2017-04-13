package com.oh.my.news.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/4/13.
 */
public class ImageReadDaoTestCase extends TestCase {

    private ImageReadDao imageReadDao;

    public ImageReadDaoTestCase() {
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.imageReadDao = (ImageReadDao) applicationContext.getBean("imageReadDaoImpl");
    }

    public void testQueryImageById(){
        try {
            System.out.println( this.imageReadDao.queryImageById(2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
