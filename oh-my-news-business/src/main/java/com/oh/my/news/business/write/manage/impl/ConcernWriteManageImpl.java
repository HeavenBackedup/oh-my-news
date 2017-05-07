package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.ConcernWriteDao;
import com.oh.my.news.business.write.manage.ConcernWriteManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
@Service
public class ConcernWriteManageImpl implements ConcernWriteManage {
    @Autowired
    private ConcernWriteDao concernWriteDao;
    public void deleteFollower(int userId,int followerId)throws Exception{
        concernWriteDao.deleteConcernByIds(userId,followerId);
    }
    public Integer addFollower(int userId,int followerId)throws Exception{
       return concernWriteDao.insertConcernByIds(userId,followerId);
    }
}
