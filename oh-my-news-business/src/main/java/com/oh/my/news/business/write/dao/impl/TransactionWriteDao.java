package com.oh.my.news.business.write.dao.impl;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface TransactionWriteDao {

    void insertTransactionByIds(Integer source_user_id,Integer target_user_id,Integer amount,Integer article_id,String message) throws Exception;


}