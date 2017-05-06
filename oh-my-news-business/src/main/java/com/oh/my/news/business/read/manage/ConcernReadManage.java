package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by Dzhaoooo on 2017/5/1.
 */
public interface ConcernReadManage {
    /**
     *
     * @param userId
     * @return 返回该userId的对应关注人列表 包含最基本的信息（id,imageurl,nickname,signature)
     * @throws Exception
     */
    List<UserSnapshot> getMyConcerns(int userId)throws Exception;

    /**
     *
     * @param userId
     * @return  返回该userId的对应粉丝列表 包含最基本的信息（id,imageurl,nickname,signature)
     * @throws Exception
     */
    List<UserSnapshot> getMyFans(int userId)throws Exception;


    /**
     *
     * @param userId 该登录用户的id
     * @param followerId  要验证的关注人id
     * @return 判断该followerId是否在用户的关注列表中，是返回true，否则返回false
     * @throws Exception
     */

    boolean concernValidation(int userId,int followerId)throws Exception;
}
