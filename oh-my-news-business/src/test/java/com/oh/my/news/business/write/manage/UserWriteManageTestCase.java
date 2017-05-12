package com.oh.my.news.business.write.manage;

import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.dto.UserFontWrite;
import com.oh.my.news.model.po.UserWrite;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by llf on 2017/5/6.
 */
public class UserWriteManageTestCase extends TestCase{
    private UserWriteManage userWriteManage;

    public UserWriteManageTestCase() {
        System.setProperty("global.config.path","D:/gitcode/env/env-dev");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.userWriteManage = (UserWriteManage)applicationContext.getBean("userWriteManageImpl");
    }
    public void testRegister(){
        UserWrite user=new UserWrite();
        user.setUsername("llf3");
        user.setEmail("123456736@qq.com");
        user.setPassword("123456");
        try {
            this.userWriteManage.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testEditSignature(){
        try {
            this.userWriteManage.editSignature(1,"haha");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testEditAnouncement(){
        try {
            this.userWriteManage.editAnouncement(1,"iahdhjnnjx");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testUpdate(){
        UserFontWrite user=new UserFontWrite();
        String[] str={"1","2","3"};
        user.setId(1);
        user.setUsername("llf3");
        user.setPassword("1234567");
        user.setEmail("123456@qq.com");
        user.setAddress(str);
        user.setMedia_id(1);
        try {
            this.userWriteManage.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
