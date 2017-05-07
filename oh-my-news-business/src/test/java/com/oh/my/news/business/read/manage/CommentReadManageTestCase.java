package com.oh.my.news.business.read.manage;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
public class CommentReadManageTestCase extends TestCase {
    private CommentReadManage commentReadManage;

    public CommentReadManageTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.commentReadManage=(CommentReadManage)applicationContext.getBean("commentReadManageImpl");
    }

    public void testGetComments(){
        try {
            System.out.println(commentReadManage.getComments(1,1,2));

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
