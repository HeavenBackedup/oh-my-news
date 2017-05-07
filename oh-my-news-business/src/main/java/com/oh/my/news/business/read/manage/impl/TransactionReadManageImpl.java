package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.TransactionReadDao;
import com.oh.my.news.business.read.manage.TransactionReadManage;
import com.oh.my.news.model.po.TransactionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class TransactionReadManageImpl implements TransactionReadManage {
    @Autowired
    private TransactionReadDao transactionReadDao;
    @Override
    public List<TransactionPo> getPayevents(int userId)throws Exception{
        return  transactionReadDao.Payevents(userId);
    }
    @Override
    public List<TransactionPo> getIncomeevents(int userId)throws Exception{
        return transactionReadDao.Incomeevents(userId);
    }

    @Override
     public int getWithDraw(int userId,int sum)throws Exception{


            return transactionReadDao.getWithDraw(userId, sum);


     }

    @Override
    public int getRecharge(int userId,int sum)throws Exception{

             return transactionReadDao.getRecharge(userId, sum);


    }





}