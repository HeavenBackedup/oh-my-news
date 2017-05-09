package com.oh.my.news.business.write.manage;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface TransactionWriteManage {




    public int setWithDraw(int userId, int sum)throws Exception;

    public int setRecharge(int userId,int sum)throws Exception;


}
