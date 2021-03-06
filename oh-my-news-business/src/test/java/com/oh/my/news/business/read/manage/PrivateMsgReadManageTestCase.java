package com.oh.my.news.business.read.manage;

import com.oh.my.news.business.write.manage.ImageWriteManage;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/5/9.
 */
public class PrivateMsgReadManageTestCase extends TestCase {

    private PrivateMsgReadManage privateMsgReadManage;

    public PrivateMsgReadManageTestCase() {

//        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.privateMsgReadManage = (PrivateMsgReadManage) applicationContext.getBean("privateMsgReadManageImpl");
    }

    public void testGetPrivateMsg(){
        try {
            System.out.println(this.privateMsgReadManage.getPrivateMsg(2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    public void testGetUnReadedPrivateMsg(){
        try {
            System.out.println(this.privateMsgReadManage.getUnReadedPrivateMsg(2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testGetReadedPrivateMsg(){
        try {
            System.out.println(this.privateMsgReadManage.getReadedPrivateMsg(2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void testGetExMsg(){
        try {
            System.out.println(this.privateMsgReadManage.getExMsg(28,2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void testGetExMsgALl(){
        try {
            System.out.println(this.privateMsgReadManage.getExMsgALl(28,2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
