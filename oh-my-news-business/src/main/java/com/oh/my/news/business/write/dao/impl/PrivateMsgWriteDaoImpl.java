package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.PrivateMsgWriteDao;
import com.oh.my.news.model.po.PrivateMessagePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class PrivateMsgWriteDaoImpl implements PrivateMsgWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;
    public Integer insertPrivateMessageReturnId(PrivateMessagePo privateMessagePo)throws Exception{

       return (Integer)sqlMapClient.insert("private_message_sqlMap.insert_private_message",privateMessagePo);


    }

}
