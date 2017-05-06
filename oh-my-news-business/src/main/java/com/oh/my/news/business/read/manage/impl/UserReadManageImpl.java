package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserFont;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by llf on 2017/5/4.
 */
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
            return false;
        }else{
            return true;
        }
    }

    public boolean emailValidation(String email) throws Exception {

        if(userReadDao.verifyUserbyemail(email)!=null){
            return false;
        }else {
            return true;
        }
    }

    public UserFont getUserDetail(int userId) throws Exception {
        UserDto userDto=userReadDao.queryUserDetail(userId);
        String[] address=userDto.getAddress().split(",");
        UserFont userFont=new UserFont();
        userFont.setId(userDto.getId());
        userFont.setUsername(userDto.getUsername());
        userFont.setPassword(userDto.getPassword());
        userFont.setNickname(userDto.getNickname());
        return null;
    }
}
