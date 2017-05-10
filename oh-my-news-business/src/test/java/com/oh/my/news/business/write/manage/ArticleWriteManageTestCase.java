//package com.oh.my.news.business.write.manage;
//
//import com.oh.my.news.business.read.dao.ImageReadDao;
//import com.oh.my.news.business.write.manage.ArticleWriteManage;
//import com.oh.my.news.model.dto.EditContentWrite;
//import junit.framework.Assert;
//import junit.framework.TestCase;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Arrays;
//
///**
// * Created by shj on 2017/5/9.
// */
//public class ArticleWriteManageTestCase extends TestCase{
//
//    private ArticleWriteManage articleWriteManage;
//
//    public ArticleWriteManageTestCase(){
//        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
//        this.articleWriteManage = (ArticleWriteManage) applicationContext.getBean("articleWriteManageImpl");
//    }
//
//    public void testPublish(){
//        try {
//            EditContentWrite editContentWrite =  new EditContentWrite();
//            editContentWrite.setTopic("测试文章");
//            editContentWrite.setUserId(2);
//            editContentWrite.setHtmlContent("<p>测试写入</p>");
//            editContentWrite.setContentSnapshot("测试写入");
//            editContentWrite.setCategoryId(1);
//            editContentWrite.setLabels("labels");
//            articleWriteManage.publish(editContentWrite);
//            EditContentWrite editContentWrite1 =  new EditContentWrite();
//            editContentWrite1.setId(3);
//            editContentWrite1.setTopic("测试文章");
//            editContentWrite1.setUserId(3);
//            editContentWrite1.setHtmlContent("<p>测试写入</p>");
//            editContentWrite1.setContentSnapshot("测试写入");
//            editContentWrite1.setCategoryId(1);
//            editContentWrite1.setLabels("labels");
//            editContentWrite1.setMediaIds(Arrays.asList(new Integer[]{2,4,5}));
//            articleWriteManage.publish(editContentWrite1);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//
//    }
//
//    public void testSave(){
//        try {
//            EditContentWrite editContentWrite =  new EditContentWrite();
//            editContentWrite.setTopic("测试保存文章");
//            editContentWrite.setUserId(2);
//            editContentWrite.setHtmlContent("<p>测试保存写入</p>");
//            editContentWrite.setContentSnapshot("测试保存写入");
//            editContentWrite.setCategoryId(1);
//            editContentWrite.setLabels("labels");
//            articleWriteManage.save(editContentWrite);
//            EditContentWrite editContentWrite1 =  new EditContentWrite();
//            editContentWrite1.setId(4);
//            editContentWrite1.setTopic("测试文章保存修改怒");
//            editContentWrite1.setUserId(3);
//            editContentWrite1.setHtmlContent("<p>测试文章保存修改</p>");
//            editContentWrite1.setContentSnapshot("测试写入");
//            editContentWrite1.setCategoryId(1);
//            editContentWrite1.setLabels("labels");
//            editContentWrite1.setMediaIds(Arrays.asList(new Integer[]{2,4,5}));
//            articleWriteManage.save(editContentWrite1);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//    }
//
//    public void testThumbUp(){
//        try {
//            articleWriteManage.thumUp(2,14);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    public void  testDonate(){
//        try {
//            articleWriteManage.donate(2,14,20,"老子有钱");
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    public void testCollect(){
//        try {
//            articleWriteManage.collect(2,14);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//    }
//
//
//    public void testMark(){
//        try {
//            articleWriteManage.mark(2,14,3.6f);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    public void testReport(){
//        try {
//            articleWriteManage.report(2,14);
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//}
