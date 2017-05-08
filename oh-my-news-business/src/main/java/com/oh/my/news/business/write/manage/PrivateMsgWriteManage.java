package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/1.
 */
public interface PrivateMsgWriteManage {
    /**
     *
     * @param sourceId 发送方id
     * @param targetId 接受方id
     * @param content  具体私信内容
     * @throws Exception
     */
    void sendMsg(int sourceId,int targetId,String content)throws Exception;




}
