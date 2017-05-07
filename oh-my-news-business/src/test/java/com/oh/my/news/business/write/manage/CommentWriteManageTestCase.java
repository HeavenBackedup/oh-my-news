package com.oh.my.news.business.write.manage;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
public class CommentWriteManageTestCase extends TestCase {
    private CommentWriteManage commentWriteManage;

    public CommentWriteManageTestCase(){
        System.setProperty("global.config.path","/Users/Dzhaoooo/GitProjects/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.commentWriteManage=(CommentWriteManage)applicationContext.getBean("commentWriteManageImpl");
    }

    public void testWriteComment(){
        try {
            //成功插入信息测试
            commentWriteManage.writeComment(1,27,1,"这是第一篇新闻的第二条根评论下的子评论");
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
        try {
            //错误插入信息测试
            commentWriteManage.writeComment(2,28,1,"这是一个错误的评论");
            Assert.fail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
