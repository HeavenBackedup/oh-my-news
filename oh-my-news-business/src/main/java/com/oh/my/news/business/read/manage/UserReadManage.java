package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface UserReadManage {
    /**
     *
     * @param username
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    Integer login(String username,String email,String password)throws Exception;

    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    boolean userValidation(String username)throws Exception;

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    boolean emailValidation(String email)throws Exception;





    UserDto getUserDetail(int userId)throws Exception;
}
