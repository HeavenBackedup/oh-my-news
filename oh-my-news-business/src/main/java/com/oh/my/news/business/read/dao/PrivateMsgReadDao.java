package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.PrivateMessage;
import com.oh.my.news.model.po.PrivateMsgSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface PrivateMsgReadDao {
   /**
    *
    * @param sourceUserId
    * @param targetUserId
    * @return
    * @throws Exception
    */
   List<PrivateMessage> queryExMsg(Integer sourceUserId,Integer targetUserId) throws Exception;

   /**
    *
    * @param userId
    * @return
    * @throws Exception
    */
   List queryPrivateMessage(Integer userId) throws Exception;

   /**
    *
    * @param userId
    * @param type
    * @return
    * @throws Exception
    */
   List<PrivateMsgSnapshot> querySouceIdsByUserId(Integer userId,Integer type)throws Exception;

   /**
    *
    * @param userId
    * @param type
    * @return
    * @throws Exception
    */
   List<PrivateMsgSnapshot> queryTargetIdsByUserId(Integer userId,Integer type)throws Exception;

   /**
    *
    * @param ids
    * @return
    * @throws Exception
    */
   List<PrivateMessage> querySourceMessageByIds(List<Integer> ids)throws Exception;

   /**
    *
    * @param ids
    * @return
    * @throws Exception
    */
   List<PrivateMessage> queryTargetMessageByIds(List<Integer> ids)throws Exception;

   List<PrivateMessage> queryLatestMessage(Integer userId,Integer type)throws Exception;

   List<PrivateMessage> querySourceMsgBySourceIdAndTargetId(Integer sourceUserId,Integer targetUserId)throws Exception;

   List<PrivateMessage> queryTargetMsgBySourceIdAndTargetId(Integer sourceUserId,Integer targetUserId)throws Exception;
}
