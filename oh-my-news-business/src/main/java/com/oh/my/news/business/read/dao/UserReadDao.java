package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserReadDao {
    Integer verifyUserbyuername(String username) throws Exception;
    Integer verifyUserbyemail(String email) throws Exception;
    Integer queryUserbyusername(String username,String password) throws Exception;
    Integer queryUserbyemail(String email,String password) throws Exception;
    UserDto queryUserDetail(int userId) throws Exception;
    UserSnapshot getUserSnapshotById(int id)throws Exception;
}
