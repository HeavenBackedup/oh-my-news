package com.oh.my.news.business.read.dao.impl;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.PrivateMsgReadDao;
import com.oh.my.news.model.dto.PrivateMessage;
import com.oh.my.news.model.po.PrivateMsgSnapshot;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class PrivateMsgReadDaoImpl implements PrivateMsgReadDao{
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;
    public List queryPrivateMessage(Integer userId) throws Exception{

        return sqlMapClient.queryForList("queryObject_private_message_by_id");
    }
    public List<PrivateMessage> queryExMsg(Integer sourceUserId, Integer targetUserId) throws Exception{


        return (List<PrivateMessage>)sqlMapClient.queryForList("private_message_sqlMap.queryList_private_message_by_id");
    }

    @Override
    public List<PrivateMessage> querySourceMessageByIds(List<Integer> ids) throws Exception {
        return (List<PrivateMessage>) sqlMapClient.queryForList("private_message_sqlMap.query_source_private_message_by_ids",ids);
    }

    @Override
    public List<PrivateMessage> queryTargetMessageByIds(List<Integer> ids) throws Exception {
        return (List<PrivateMessage>) sqlMapClient.queryForList("private_message_sqlMap.query_target_private_message_by_ids",ids);
    }

    @Override
    public List<PrivateMsgSnapshot> querySouceIdsByUserId(Integer userId, Integer type) throws Exception {
        Map<String,Object> map =new HashedMap();
        map.put("userId",userId);
        map.put("type",type);

        return sqlMapClient.queryForList("private_message_sqlMap.query_source_ids_by_user_id",map);
    }

    @Override
    public List<PrivateMsgSnapshot> queryTargetIdsByUserId(Integer userId, Integer type) throws Exception {
        Map<String,Object> map =new HashedMap();
        map.put("userId",userId);
        map.put("type",type);
        return sqlMapClient.queryForList("private_message_sqlMap.query_target_ids_by_user_id",map);
    }

    @Override
    public List<PrivateMessage> queryLatestMessage(Integer userId, Integer type) throws Exception {
        Map<String,Object> map =new HashedMap();
        map.put("userId",userId);
        map.put("type",type);
        return sqlMapClient.queryForList("private_message_sqlMap.query_latest_message",map);
    }

    @Override
    public List<PrivateMessage> querySourceMsgBySourceIdAndTargetId(Integer sourceUserId, Integer targetUserId) throws Exception {
        Map<String,Object> map =new HashedMap();
        map.put("sourceId",sourceUserId);
        map.put("targetId",targetUserId);
        return sqlMapClient.queryForList("private_message_sqlMap.query_source_private_message_by_source_id_and_target_id",map);
    }

    @Override
    public List<PrivateMessage> queryTargetMsgBySourceIdAndTargetId(Integer sourceUserId, Integer targetUserId) throws Exception {
        Map<String,Object> map =new HashedMap();
        map.put("sourceId",sourceUserId);
        map.put("targetId",targetUserId);
        return sqlMapClient.queryForList("private_message_sqlMap.query_target_private_message_by_target_id_and_target_id",map);

    }
}
