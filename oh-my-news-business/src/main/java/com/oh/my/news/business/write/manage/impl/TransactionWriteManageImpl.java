package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.read.dao.WalletReadDao;
import com.oh.my.news.business.write.dao.WalletWriteDao;
import com.oh.my.news.business.write.dao.TransactionWriteDao;
import com.oh.my.news.business.write.manage.TransactionWriteManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/4.
 */
@Repository
public class TransactionWriteManageImpl implements TransactionWriteManage{
    @Autowired
    private  TransactionWriteDao transactionWriteDao;
    @Autowired
    private WalletReadDao walletReadDao;
    @Autowired
    private WalletWriteDao walletWriteDao;

    @Override
    public void addEvents(Integer source_user_id,Integer target_user_id,Integer amount,Integer article_id,String message) throws Exception {
        transactionWriteDao.insertTransactionByIds(source_user_id,target_user_id, amount, article_id,message);
    }


    @Override
    public int setWithDraw(int userId, int sum)throws Exception{
        synchronized(this) {
            float ballance = walletReadDao.getFigure(userId);
            int sum_after = (int)ballance-sum;
            int id;
            if (sum <= ballance) {
                transactionWriteDao.insertTransactionByIds(userId,null, -sum, 0,"提现");
                id=walletReadDao.queryIdByUserId(userId);
                walletWriteDao.updateWalletFigure(id, sum_after);
                return 0;
            } else {
                return 1;
            }
        }
    }
    @Override
    public int setRecharge(int userId,int sum)throws Exception{
        synchronized (this){
            int id;
            float ballance = walletReadDao.getFigure(userId);
            id=walletReadDao.queryIdByUserId(userId);
            transactionWriteDao.insertTransactionByIds(userId,null, sum, 0,"充值");
            walletWriteDao.updateWalletFigure(id,(int)ballance+sum);
            walletWriteDao.setWalletMaxFigure(id);
            return 0;
        }

    }





}
