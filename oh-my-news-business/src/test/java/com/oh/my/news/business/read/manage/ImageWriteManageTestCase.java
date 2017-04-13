package com.oh.my.news.business.read.manage;

import com.oh.my.news.business.read.dao.ImageReadDao;
import com.oh.my.news.business.write.manage.ImageWriteManage;
import com.oh.my.news.model.dto.Image;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by shj on 2017/4/13.
 */
public class ImageWriteManageTestCase extends TestCase{

    private ImageWriteManage imageWriteManage;

    public ImageWriteManageTestCase() {
        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.imageWriteManage = (ImageWriteManage) applicationContext.getBean("imageWriteManageImpl");
    }


    public void testSaveImageReturnId(){
        File file = new File("/Users/shj/dev/workspace/oh-my-news/oh-my-news-web/src/main/webapp/images/hpic.jpeg");
        System.out.println(file.exists());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Image image =imageWriteManage.saveImageReturnId(fileInputStream);
            System.out.println(image);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

}
