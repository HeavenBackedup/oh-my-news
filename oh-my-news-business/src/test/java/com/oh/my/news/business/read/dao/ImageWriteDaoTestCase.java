package com.oh.my.news.business.read.dao;

import com.oh.my.news.business.write.dao.ImageWriteDao;
import com.oh.my.news.model.po.File;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/4/13.
 */
public class ImageWriteDaoTestCase extends TestCase {

    private ImageWriteDao imageWriteDao;


    public ImageWriteDaoTestCase() {
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.imageWriteDao = (ImageWriteDao) applicationContext.getBean("imageWriteDaoImpl");
    }

    public void testInsertImageReturnId(){
        try {
            System.out.println(this.imageWriteDao.insertImageReturnId(new File(0,"test","www.baidu.com",0)));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
