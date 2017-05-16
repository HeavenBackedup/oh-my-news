package com.oh.my.news.business.read.manage;

import com.oh.my.news.business.read.dao.TransactionReadDao;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/5/17.
 */
public class TransactionReadManageTestCase extends TestCase {


    private TransactionReadManage transactionReadManage;

    public TransactionReadManageTestCase() {
//        System.setProperty("global.config.path", "F:\\thefirstproject\\env\\env\\env-dev");
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-business/spring-service.xml");
        this.transactionReadManage=(TransactionReadManage) applicationContext.getBean("transactionReadManageImpl");
    }

    public void testGetIncomeevents(){
        try {
            System.out.println(            this.transactionReadManage.getIncomeevents(2,1,10));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testGetPayevents(){
        try {
            System.out.println(this.transactionReadManage.getPayevents(2,1,10));

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
