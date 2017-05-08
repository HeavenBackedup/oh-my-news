package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.PrivateMessage;

import java.util.List;

/**
 * Created by shj on 2017/5/2.
 */
public interface PrivateMsgReadManage {
    /**
     *
     * @param userId
     * @return 返回该用户所有的私信对象的列表
     * @throws Exception
     */
    List<PrivateMessage> getPrivateMsg(int userId)throws Exception;

    /**
     *
     * @param sourceUserId 登录用户的id
     * @param targetUserId 要进行查询的用户id
     * @return 返回该用户与查询用户对话的所有私信列表
     * @throws Exception
     */
    List<PrivateMessage> getExMsg(int sourceUserId,int targetUserId)throws Exception;
}
