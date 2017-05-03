package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.Concern;

/**
 * Created by shj on 2017/5/3.
 */
public interface ConcernWriteDao {
    Integer insertConcernReturnId(Concern concern)throws Exception;

}
