package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.vo.User;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface UserWriteManage {

    /**
     * 用户注册
     * @param user
     * @throws Exception
     */
    void register(User user)throws Exception;

    /**
     * 编辑用户主页的signature
     * @param userId
     * @param signature 修改的signature
     * @throws Exception
     */
    void editSignature(String userId,String signature)throws Exception;

    /**
     * 编辑用户主页的annoucement
     * @param userId
     * @param annoucement 修改的annoucement
     * @throws Exception
     */
    void editAnouncement(String userId,String annoucement)throws Exception;
}
