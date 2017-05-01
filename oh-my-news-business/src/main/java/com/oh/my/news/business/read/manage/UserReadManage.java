package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface UserReadManage {
    Integer login(String username,String email,String password)throws Exception;

    boolean userValidation(String username)throws Exception;

    boolean emailValidation(String email)throws Exception;

    List<UserSnapshot> getMyConcerns(int userId)throws Exception;

    List<UserSnapshot> getMyFans(int userId)throws Exception;
}
