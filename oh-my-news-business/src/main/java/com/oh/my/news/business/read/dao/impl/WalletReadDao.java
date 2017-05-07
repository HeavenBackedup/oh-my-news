package com.oh.my.news.business.read.dao.impl;

import com.oh.my.news.model.dto.Wallet;

/**
 * Created by shj on 2017/5/3.
 */
public interface WalletReadDao {
    Wallet getUserById(int id)throws Exception;
}
