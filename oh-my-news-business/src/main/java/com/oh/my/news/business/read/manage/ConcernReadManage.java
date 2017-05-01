package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface ConcernReadManage {
    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    List<UserSnapshot> getMyConcerns(int userId)throws Exception;

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    List<UserSnapshot> getMyFans(int userId)throws Exception;


    boolean concernValidation(int userId,int followerId)throws Exception;
}
