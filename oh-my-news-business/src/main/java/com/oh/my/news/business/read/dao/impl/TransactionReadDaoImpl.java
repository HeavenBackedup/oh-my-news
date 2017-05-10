package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.TransactionReadDao;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.Transaction;
import com.oh.my.news.model.po.TransactionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@Repository
public class TransactionReadDaoImpl implements TransactionReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;


    public List<TransactionPo> Payevents(int userId)throws Exception{
        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.queryOut_transaction_by_id",userId);
    }

    public List<TransactionPo> Incomeevents(int userId)throws Exception{

        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.queryIn_transaction_by_id",userId);
    }

    public List<Transaction> donated(int userId)throws Exception{///与数据库清单保持一致smy

        return (List<Transaction>)sqlMapClient.queryForList("transaction_sqlMap.queryOut_raw_transaction_by_id",userId);
    }






}
