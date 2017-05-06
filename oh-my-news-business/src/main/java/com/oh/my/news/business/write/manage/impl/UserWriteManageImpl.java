package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.UserWriteDao;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by llf on 2017/5/4.
 */
public class UserWriteManageImpl implements UserWriteManage {
    @Autowired
    private UserWriteDao userWriteDao;
    public void register(User user) throws Exception {
        userWriteDao.insertUser(user);
    }

    public void editSignature(String userId, String signature) throws Exception {

    }

    public void editAnouncement(String userId, String annoucement) throws Exception {

    }

    public void update(User user) throws Exception {

    }
}
