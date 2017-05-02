package com.oh.my.news.business.read.manage;

/**
 * Created by shj on 2017/5/2.
 */
public interface PrivateMsgReadManage {

    void getPrivateMsg(int userId)throws Exception;
    void getExMsg(int sourceUserId,int targetUserId)throws Exception;
}
