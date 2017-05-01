package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/1.
 */
public interface PrivateMagWriteManage {

    void sendMsg(int sourceId,int targetId,String content)throws Exception;
}
