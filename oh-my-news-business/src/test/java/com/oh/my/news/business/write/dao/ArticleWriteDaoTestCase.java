package com.oh.my.news.business.write.dao;

import com.oh.my.news.business.write.manage.ArticleWriteManage;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by shj on 2017/5/18.
 */
public class ArticleWriteDaoTestCase extends TestCase {
    private ArticleWriteDao articleWriteDao;

    public ArticleWriteDaoTestCase(){

        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.articleWriteDao = (ArticleWriteDao) applicationContext.getBean("articleWriteDaoImpl");
    }

    public void testUpdateDonate(){
        try {
            this.articleWriteDao.updateDonate(28,100);
        }catch (SQLException e){
            e.printStackTrace();
            Assert.fail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
