package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.po.Transaction;
import com.oh.my.news.model.po.TransactionPo;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface TransactionReadDao {
    List<TransactionPo> Payevents(int userId)throws Exception;
    List<TransactionPo> Incomeevents(int userId)throws Exception;
    List<Transaction> donated(int userId)throws Exception;///与数据库清单保持一致smy
}
