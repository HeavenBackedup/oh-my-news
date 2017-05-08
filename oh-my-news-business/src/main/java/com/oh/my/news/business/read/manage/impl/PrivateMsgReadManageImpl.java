package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.PrivateMsgReadDao;
import com.oh.my.news.business.read.manage.PrivateMsgReadManage;
import com.oh.my.news.model.dto.PrivateMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public class PrivateMsgReadManageImpl implements PrivateMsgReadManage {
    private PrivateMsgReadDao privateMsgReadDao;
   public List<PrivateMessage> getPrivateMsg(int userId)throws Exception{
       return privateMsgReadDao.queryPrivateMessage(userId);

   }
   public List<PrivateMessage> getExMsg(int sourceUserId,int targetUserId)throws Exception{


       return privateMsgReadDao.queryExMsg(sourceUserId,targetUserId);

   }


}
