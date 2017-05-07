package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.impl.TransactionWriteDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/5/4.
 */

public class TransactionWriteManageImpl {
    @Autowired
    private  TransactionWriteDao transactionWriteDao;
   public void addEvents(Integer source_user_id,Integer target_user_id,Integer amount,Integer article_id,String message)throws Exception{
         transactionWriteDao.insertTransactionByIds(source_user_id,target_user_id, amount, article_id,message);
   }



}
