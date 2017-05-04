package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.ConcernWriteDao;
import com.oh.my.news.business.write.manage.ConcernWriteManage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
public class ConcernWriteManageImpl implements ConcernWriteManage {
    @Autowired
    private ConcernWriteDao concernWriteDao;
    public void deleteFollower(int userId,int followerId)throws Exception{
        concernWriteDao.deleteConcernByIds(userId,followerId);
    }
    public void addFollower(int userId,int followerId)throws Exception{
        concernWriteDao.insertConcernByIds(userId,followerId);
    }
}
