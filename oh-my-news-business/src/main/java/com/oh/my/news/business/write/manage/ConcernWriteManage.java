package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/1.
 */
public interface ConcernWriteManage {


    void deleteFollower(int userId,int followerId)throws Exception;

    void addFollower(int userId,int followerId)throws Exception;


}
