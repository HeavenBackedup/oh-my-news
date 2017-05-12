package com.oh.my.news.business.read.dao;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface WalletReadDao {

    float getFigure(int userId) throws Exception;
    float getMaxFigure(int userId) throws Exception;
    Integer queryIdByUserId(int userId)throws Exception;
}
