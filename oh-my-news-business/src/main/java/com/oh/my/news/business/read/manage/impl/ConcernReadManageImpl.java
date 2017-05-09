package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.ConcernReadDao;
import com.oh.my.news.business.read.manage.ConcernReadManage;
import com.oh.my.news.model.dto.UserSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
@Service
public class ConcernReadManageImpl implements ConcernReadManage {
    @Autowired
    private ConcernReadDao concernReadDao;
    public List<UserSnapshot> getMyConcerns(int userId)throws Exception{
       return concernReadDao.queryMyConcernsById(userId);
    }

    public List<UserSnapshot> getMyFans(int userId)throws Exception{
        return concernReadDao.queryMyFansById(userId);
    }

    public boolean concernValidation(int userId,int followerId)throws Exception{
        return concernReadDao.checkConcernRelById(userId,followerId);
    }


}
