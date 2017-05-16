package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.TransactionReadDao;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.Transaction;
import com.oh.my.news.model.po.TransactionPo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    public List<TransactionPo> PayeventsSelf(int userId)throws Exception{


        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.queryOutSelf_transaction_by_id",userId);

    }
    public List<TransactionPo> Incomeevents(int userId)throws Exception{

        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.queryIn_transaction_by_id",userId);
    }
    public List<TransactionPo> IncomeeventsSelf(int userId)throws Exception{

        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.queryInSelf_transaction_by_id",userId);
    }

    public List<Transaction> donated(int userId)throws Exception{///与数据库清单保持一致smy

        return (List<Transaction>)sqlMapClient.queryForList("transaction_sqlMap.queryOut_raw_transaction_by_id",userId);
    }

    public Integer IncomeeventsPageCount(int userId, int currentPage, int pageItemNum) throws Exception {
        return (Integer) sqlMapClient.queryForObject("transaction_sqlMap.query_in_transaction_count_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public Integer IncomeeventsSelfPageCount(int userId, int currentPage, int pageItemNum) throws Exception {
        return (Integer) sqlMapClient.queryForObject("transaction_sqlMap.query_in_self_transaction_count_by_id",paginationPackage(userId,currentPage,pageItemNum));    }

    public List<TransactionPo> Payevents(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>) sqlMapClient.queryForList("transaction_sqlMap.query_out_transaction_page_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public List<TransactionPo> PayeventsSelf(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>) sqlMapClient.queryForList("transaction_sqlMap.query_out_self_transaction_page_by_id",paginationPackage(userId,currentPage,pageItemNum));    }

    public Integer PayeventsPageCount(int userId, int currentPage, int pageItemNum) throws Exception {
        return (Integer) sqlMapClient.queryForObject("transaction_sqlMap.query_out_transaction_count_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public Integer PayeventsSelfPageCount(int userId, int currentPage, int pageItemNum) throws Exception {
        return (Integer) sqlMapClient.queryForObject("transaction_sqlMap.query_out_self_transaction_count_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public List<TransactionPo> Incomeevents(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>) sqlMapClient.queryForList("transaction_sqlMap.query_in_transaction_page_by_id",paginationPackage(userId,currentPage,pageItemNum));    }

    public List<TransactionPo> IncomeeventsSelf(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>) sqlMapClient.queryForList("transaction_sqlMap.query_in_self_transaction_page_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public List<TransactionPo> getIncomeEventAll(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>) sqlMapClient.queryForList("transaction_sqlMap.query_in_page_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public List<TransactionPo> getPayEventsAll(int userId, int currentPage, int pageItemNum) throws Exception {
        return (List<TransactionPo>)sqlMapClient.queryForList("transaction_sqlMap.query_out_page_by_id",paginationPackage(userId,currentPage,pageItemNum));
    }

    public Integer getIncomeEventCount(int userId) throws Exception {
        return (Integer) sqlMapClient.queryForObject("transaction_sqlMap.query_in_count_by_id",userId);
    }

    public Integer getPayEventCount(int userId) throws Exception {
        return (Integer)sqlMapClient.queryForObject("transaction_sqlMap.query_out_count_by_id",userId);
    }

    private Map<String,Object> paginationPackage(int userId, int currentPage, int pageItemNum){
        Map<String,Object> map = new HashedMap();
        map.put("id",userId);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        map.put("pageItemNum",pageItemNum);
        return map;
    }


}
