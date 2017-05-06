package com.oh.my.news.business.write.dao;

/**
 * Created by shj on 2017/5/3.
 */
public interface ConcernWriteDao {
    void deleteConcernByIds(Integer userId,Integer followerId ) throws Exception;
    Integer insertConcernByIds(Integer userId,Integer followerId ) throws Exception;
}
