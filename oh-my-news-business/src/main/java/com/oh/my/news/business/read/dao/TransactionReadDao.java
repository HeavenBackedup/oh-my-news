package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.po.Transaction;
import com.oh.my.news.model.po.TransactionPo;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface TransactionReadDao {
    List<TransactionPo> Payevents(int userId)throws Exception;

    List<TransactionPo> Incomeevents(int userId)throws Exception;
    List<TransactionPo> PayeventsSelf(int userId)throws Exception;
    List<TransactionPo> IncomeeventsSelf(int userId)throws Exception;
    List<Transaction> donated(int userId)throws Exception;///与数据库清单保持一致smy

    List<TransactionPo> Payevents(int userId,int currentPage,int pageItemNum)throws Exception;
    List<TransactionPo> Incomeevents(int userId,int currentPage,int pageItemNum)throws Exception;
    List<TransactionPo> PayeventsSelf(int userId,int currentPage,int pageItemNum)throws Exception;
    List<TransactionPo> IncomeeventsSelf(int userId,int currentPage,int pageItemNum)throws Exception;

    Integer PayeventsPageCount(int userId,int currentPage,int pageItemNum)throws Exception;
    Integer IncomeeventsPageCount(int userId,int currentPage,int pageItemNum)throws Exception;
    Integer PayeventsSelfPageCount(int userId,int currentPage,int pageItemNum)throws Exception;
    Integer IncomeeventsSelfPageCount(int userId,int currentPage,int pageItemNum)throws Exception;

    List<TransactionPo> getPayEventsAll(int userId,int currentPage,int pageItemNum)throws Exception;

    List<TransactionPo> getIncomeEventAll(int userId,int currentPage,int pageItemNum)throws Exception;

    Integer getPayEventCount(int userId)throws Exception;

    Integer getIncomeEventCount(int userId)throws Exception;
}
