package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.TransactionWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/4.
 */
@Repository
public class TransactionWriteDaoImpl implements TransactionWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public  void insertTransactionByIds(Integer source_user_id,Integer target_user_id,Integer amount,Integer article_id,String message) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("source_user_id",source_user_id);
        map.put("target_user_id",target_user_id);
        map.put("amount",amount);
        map.put("article_id",article_id);
        map.put("message",message);
        sqlMapClient.insert("transaction_sqlMap.insert_transaction_by_id",map);
    }
}
