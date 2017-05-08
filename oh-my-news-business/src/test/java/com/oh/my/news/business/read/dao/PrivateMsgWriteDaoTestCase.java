package com.oh.my.news.business.read.dao;

import com.oh.my.news.business.write.dao.PrivateMsgWriteDao;
import com.oh.my.news.model.po.PrivateMessagePo;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/7.
 */
public class PrivateMsgWriteDaoTestCase extends TestCase{
    private PrivateMsgWriteDao privateMsgWriteDao;
//    private PrivateMessagePo privateMessagePo;



    public PrivateMsgWriteDaoTestCase() {
        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.privateMsgWriteDao=(PrivateMsgWriteDao) applicationContext.getBean("privateMsgWriteDaoImpl");

    }
    public void testInsertPrivateMessageReturnId() {
        PrivateMessagePo privateMessagePo = new PrivateMessagePo();
        privateMessagePo.setContent("hi");
        privateMessagePo.setSourceId(2);
        privateMessagePo.setTargetId(3);
        try {
            System.out.println(this.privateMsgWriteDao.insertPrivateMessageReturnId(privateMessagePo));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }





}
