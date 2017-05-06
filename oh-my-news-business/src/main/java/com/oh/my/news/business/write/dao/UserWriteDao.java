package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserWriteDao {

    void insertUser(User user)throws Exception;
    void insertSignature(String userId,String signature)throws Exception;
    void insertAnnouncement(String userId,String announcement)throws Exception;
    void updateUser(User user)throws Exception;
}
