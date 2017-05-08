package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.PrivateMsgReadDao;
import com.oh.my.news.model.dto.PrivateMessage;
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


        return (List<PrivateMessage>)sqlMapClient.queryForList("queryList_private_message_by_id");
    }



}
