package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.TransactionReadDao;
import com.oh.my.news.business.read.dao.WalletReadDao;
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

    private TransactionReadDao transactionReadDao;
    private WalletReadDao walletReadDao;

    public List<TransactionPo> getPayevents(int userId)throws Exception{
        return  transactionReadDao.Payevents(userId);
    }

    public List<TransactionPo> getIncomeevents(int userId)throws Exception{
        return transactionReadDao.Incomeevents(userId);
    }


    public float getFigure(int userId)throws Exception{
        return walletReadDao.getFigure(userId);
    }


    public float getMaxFigure(int userId)throws Exception{

        return walletReadDao.getMaxFigure(userId);

    }




}
