package com.oh.my.news.business.write.manage;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface TransactionWriteManage {

    void addEvents(Integer source_user_id,Integer target_user_id,Integer amount,Integer article_id,String message)throws Exception;
    int setWithDraw(int userId,int sum)throws Exception;
    int setRecharge(int userId,int sum)throws Exception;

}