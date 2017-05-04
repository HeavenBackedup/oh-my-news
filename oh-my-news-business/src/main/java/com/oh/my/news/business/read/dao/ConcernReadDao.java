package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface ConcernReadDao {
    List<UserSnapshot> queryMyConcernsById(Integer id) throws Exception;
    List<UserSnapshot> queryMyFansById(Integer id) throws Exception;
    boolean checkConcernRelById(int userId,int followerId) throws Exception;
}
