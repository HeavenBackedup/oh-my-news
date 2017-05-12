package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/3.
 */
public interface UserReadDao {
    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    Integer verifyUserbyuername(String username) throws Exception;

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    Integer verifyUserbyemail(String email) throws Exception;

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    Integer queryUserbyusername(String username,String password) throws Exception;

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    Integer queryUserbyemail(String email,String password) throws Exception;

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    UserDto queryUserDetail(int userId) throws Exception;

    /**
     *
     * @param username
     * @param email
     * @return
     * @throws Exception
     */
    Integer verifyUserLimit(String username,String email) throws  Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserSnapshot getUserSnapshotById(int id)throws Exception;
    Integer getMediaIdByUserId(int id)throws Exception;
}
