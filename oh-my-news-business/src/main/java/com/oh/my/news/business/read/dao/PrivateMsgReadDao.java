package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.PrivateMessage;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface PrivateMsgReadDao {
   List<PrivateMessage> queryExMsg(Integer sourceUserId,Integer targetUserId) throws Exception;
    List queryPrivateMessage(Integer userId) throws Exception;


}
