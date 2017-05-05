package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by Dzhaoooo on 2017/5/3.
 */
public interface ConcernReadDao {
    /**
     * 通过某用户的id查询该用户的关注人列表
     * @param id 登录用户的id
     * @return 返回该用户的关注人的列表
     * @throws Exception
     */
    List<UserSnapshot> queryMyConcernsById(Integer id) throws Exception;

    /**
     * 通过某用户的id查询该用户的粉丝列表
     * @param id 登录用户的id
     * @return 返回该用户的粉丝列表
     * @throws Exception
     */
    List<UserSnapshot> queryMyFansById(Integer id) throws Exception;

    /**
     * 查询userId是否关注followerId
     * @param userId
     * @param followerId
     * @return 关注返回true 否则返回false
     * @throws Exception
     */
    boolean checkConcernRelById(int userId,int followerId) throws Exception;
}
