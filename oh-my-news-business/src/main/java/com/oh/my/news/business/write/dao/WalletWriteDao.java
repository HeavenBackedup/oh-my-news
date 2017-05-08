package com.oh.my.news.business.write.dao;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface WalletWriteDao {

    Integer insertWalletByUserId(Integer userId)throws Exception;
    void updateWalletFigure(Integer userId,Integer sum)throws Exception;
    void setWalletMaxFigure(Integer userId)throws Exception;

    }

