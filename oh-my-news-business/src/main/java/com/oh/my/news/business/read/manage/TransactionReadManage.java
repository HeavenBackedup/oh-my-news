package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.TransactionDto;
import com.oh.my.news.model.dto.Wallet;

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
    List<TransactionDto> getPayevents(int userId)throws Exception;

    /**
     *
     * @param userId
     * @return 返回该用户的所有收入事项的列表
     * @throws Exception
     */

    List<TransactionDto> getIncomeevents(int userId)throws Exception;

    /**
     *
     * @param userId
     * @param sum 具体提现金额
     * @return 返回该操作的具体状态，成功返回0，失败返回1
     * @throws Exception
     */
    int getWithDraw(int userId,int sum)throws Exception;

    /**
     *
     * @param userId
     * @param sum 具体充值金额
     * @return 返回该操作的具体状态，成功返回0，失败返回1
     * @throws Exception
     */
    int getRecharge(int userId,int sum)throws Exception;

}
