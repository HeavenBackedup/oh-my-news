package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.dto.Wallet;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface TransactionReadManage {

    List<TransactionDto> getPayevents(int userId)throws Exception;

    List<TransactionDto> getIncomeevents(int userId)throws Exception;


    int getWithDraw(int userId,int sum)throws Exception;

    int getRecharge(int userId,int sum)throws Exception;

}
