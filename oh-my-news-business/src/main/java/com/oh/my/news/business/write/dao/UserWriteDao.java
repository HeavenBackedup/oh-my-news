package com.oh.my.news.business.write.dao;


import com.oh.my.news.model.po.UserWrite;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserWriteDao {

    void insertUser(UserWrite user)throws Exception;
    void insertSignature(Integer userId,String signature)throws Exception;
    void insertAnnouncement(Integer userId,String announcement)throws Exception;
    void updateUser(UserWrite user)throws Exception;
}
