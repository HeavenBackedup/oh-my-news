package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.TransactionReadDao;
import com.oh.my.news.business.read.dao.WalletReadDao;
import com.oh.my.news.business.read.manage.TransactionReadManage;
import com.oh.my.news.model.dto.Pagination;
import com.oh.my.news.model.dto.TransactionPageDto;
import com.oh.my.news.model.po.TransactionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class TransactionReadManageImpl implements TransactionReadManage {
     @Autowired
    private TransactionReadDao transactionReadDao;
    @Autowired
    private WalletReadDao walletReadDao;

    public List<TransactionPo> getPayeventsSelf(int userId)throws Exception{


        return  transactionReadDao.PayeventsSelf(userId);

    }
    public List<TransactionPo> getPayevents(int userId)throws Exception{

        return   transactionReadDao.Payevents(userId);

    }

    public List<TransactionPo> getIncomeevents(int userId)throws Exception{

        return   transactionReadDao.Incomeevents(userId);

    }
    public List<TransactionPo> getIncomeeventsSelf(int userId)throws Exception{

        return  transactionReadDao.IncomeeventsSelf(userId);
    }

    public float getFigure(int userId)throws Exception{

        return walletReadDao.getFigure(userId);
    }


    public float getMaxFigure(int userId)throws Exception{

        return walletReadDao.getMaxFigure(userId);

    }



    public TransactionPageDto getIncomeevents(int userId, int currentPage, int pageItemNum) throws Exception {
        TransactionPageDto transactionPageDto = new TransactionPageDto();
        List<TransactionPo> transactionPos = this.transactionReadDao.getIncomeEventAll(userId,currentPage,pageItemNum);
        Integer count = this.transactionReadDao.getIncomeEventCount(userId);
        Pagination pagination = new Pagination();
        pagination.setTotalItems(count%pageItemNum==0?count/pageItemNum*10:(count/pageItemNum+1)*10);
        pagination.setCurrentPage(currentPage);
        transactionPageDto.setTransactionPos(transactionPos);
        transactionPageDto.setPagination(pagination);

        return transactionPageDto;
    }


    public TransactionPageDto getPayevents(int userId, int currentPage, int pageItemNum) throws Exception {
        TransactionPageDto transactionPageDto = new TransactionPageDto();
        transactionPageDto.setTransactionPos(this.transactionReadDao.getPayEventsAll(userId,currentPage,pageItemNum));
        Integer count = this.transactionReadDao.getPayEventCount(userId);
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        pagination.setTotalItems(count%pageItemNum==0?count/pageItemNum*10:(count/pageItemNum+1)*10);
        transactionPageDto.setPagination(pagination);
        return transactionPageDto;
    }
}
