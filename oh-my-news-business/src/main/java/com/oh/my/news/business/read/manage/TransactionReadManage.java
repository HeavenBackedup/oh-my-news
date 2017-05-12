package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.po.TransactionPo;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface TransactionReadManage {
    /**
     *
     * @param userId
     * @return 返回该用户的所有支出事项的列表
     * @throws Exception
     */
    List<TransactionPo> getPayevents(int userId)throws Exception;

    /**
     *
     * @param userId
     * @return 返回该用户的所有收入事项的列表
     * @throws Exception
     */

    List<TransactionPo> getIncomeevents(int userId)throws Exception;
    //得到自身提现数据
    List<TransactionPo> getPayeventsSelf(int userId)throws Exception;
    //得到自身充值数据
    List<TransactionPo> getIncomeeventsSelf(int userId)throws Exception;


    float getFigure(int userId)throws Exception;


    float getMaxFigure(int userId)throws Exception;

}
