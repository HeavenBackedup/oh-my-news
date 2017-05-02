package com.oh.my.news.business.write.manage;

/**
 * Created by shj on 2017/5/1.
 */
public interface ConcernWriteManage {

    /**
     * 取消关注某人
     * @param userId
     * @param followerId
     * @throws Exception
     */
    void deleteFollower(int userId,int followerId)throws Exception;

    /**
     * 开始关注某人
     * @param userId
     * @param followerId
     * @throws Exception
     */
    void addFollower(int userId,int followerId)throws Exception;


}
