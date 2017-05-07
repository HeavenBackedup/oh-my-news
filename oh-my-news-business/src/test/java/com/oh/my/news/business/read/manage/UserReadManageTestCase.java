package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserFont;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by llf on 2017/5/6.
 */
public class UserReadManageTestCase extends TestCase {
    private UserReadManage userReadManage;

    public UserReadManageTestCase() {
        System.setProperty("global.config.path","D:/gitcode/env/env-dev");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.userReadManage = (UserReadManage)applicationContext.getBean("userReadManageImpl");
    }
    public void testUsernamelogin(){
        try {
            System.out.println(this.userReadManage.usernamelogin("llf3","1234567"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testemaillogin(){
        try {
            System.out.println(this.userReadManage.emaillogin("123456@qq.com","1234567"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testUserValidation(){
        try {
            System.out.println(this.userReadManage.userValidation("llf3"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testEmailValidation(){
        try {
            System.out.println(this.userReadManage.emailValidation("123456@qq.com"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testGetUserDetail(){
//        UserFont userFont=new UserFont();
        try {
            this.userReadManage.getUserDetail(1);
//            System.out.println(userFont.getUsername()+" "+userFont.getDate());
//            for(int i=0;i<userFont.getAddress().length;i++){
//                String str=userFont.getAddress()[i];
//                System.out.println(str);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
