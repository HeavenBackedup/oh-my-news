package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by llf on 2017/5/4.
 */
@Service
public class UserReadManageImpl implements UserReadManage {
    @Autowired
    private UserReadDao userReadDao;
    public Integer usernamelogin(String username, String password) throws Exception {

        return userReadDao.queryUserbyusername(username,password);
    }

    public Integer emaillogin(String email, String password) throws Exception {
        return userReadDao.queryUserbyemail(email,password);
    }

    public boolean userValidation(String username) throws Exception {

        if( userReadDao.verifyUserbyuername(username)!=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean emailValidation(String email) throws Exception {
            Integer res = userReadDao.verifyUserbyemail(email);
        if(res!=null){
            return true;
        }else {
            return false;
        }
    }

    public UserFont getUserDetail(int userId) throws Exception {
        UserDto userDto=userReadDao.queryUserDetail(userId);
        String[] address = new String[]{};
        if(!StringUtils.isEmpty(userDto.getAddress()))
            address=userDto.getAddress().split(",");
        UserFont userFont=new UserFont();
        userFont.setSignature(userDto.getSignature());
        userFont.setId(userDto.getId());
        userFont.setUsername(userDto.getUsername());
        userFont.setPassword(userDto.getPassword());
        userFont.setNickname(userDto.getNickname());
        userFont.setAddress(address);
        userFont.setAnnouncement(userDto.getAnnouncement());
        userFont.setFans(userDto.getFans());
        userFont.setEmail(userDto.getEmail());
        userFont.setDate(userDto.getDate());
        userFont.setFollowers(userDto.getFollowers());
        userFont.setImageUrl(userDto.getImageUrl());
        userFont.setIsDelete(userDto.getIsDelete());
        userFont.setIsLimit(userDto.getIsLimit());
        userFont.setSignature(userDto.getSignature());
        return userFont;
    }

    public Integer getUserLimit(String username, String email) throws Exception {

        return userReadDao.verifyUserLimit(username,email);
    }

    @Override
    public Integer getMediaId(int id) throws Exception {
        return userReadDao.getMediaIdByUserId(id);
    }
}
