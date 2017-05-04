package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserWriteDao {

    void insertUserReturnId(User user)throws Exception;

}
