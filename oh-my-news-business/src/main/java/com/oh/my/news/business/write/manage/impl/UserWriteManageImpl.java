package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.UserWriteDao;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.dto.UserFontWrite;
import com.oh.my.news.model.po.User;
import com.oh.my.news.model.po.UserWrite;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by llf on 2017/5/4.
 */
@Service
public class UserWriteManageImpl implements UserWriteManage {
    @Autowired
    private UserWriteDao userWriteDao;
    public void register(UserWrite user) throws Exception {
        userWriteDao.insertUser(user);
    }

    public void editSignature(Integer userId, String signature) throws Exception {
        userWriteDao.insertSignature(userId,signature);
    }

    public void editAnouncement(Integer userId, String annoucement) throws Exception {
        userWriteDao.insertAnnouncement(userId,annoucement);
    }

    public void update(UserFontWrite userFontWrite) throws Exception {
        String address= StringUtils.join(userFontWrite.getAddress(),",");
        UserWrite u=new UserWrite();
        u.setId(userFontWrite.getId());
        u.setUsername(userFontWrite.getUsername());
        u.setPassword(userFontWrite.getPassword());
        u.setAddress(address);
        u.setNickname(userFontWrite.getNickname());
        u.setAnnouncement(userFontWrite.getAnnouncement());
        u.setEmail(userFontWrite.getEmail());
        u.setMedia_id(userFontWrite.getMedia_id());
        userWriteDao.updateUser(u);
    }
}
