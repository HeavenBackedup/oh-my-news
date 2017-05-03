package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserReadDao {
    User getUserById(int id)throws Exception;
}
