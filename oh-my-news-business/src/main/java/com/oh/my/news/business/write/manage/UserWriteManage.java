package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.dto.UserFontWrite;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.User;
import com.oh.my.news.model.po.UserWrite;

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
    Integer register(UserWrite user)throws Exception;

    /**
     * 编辑用户主页的signature
     * @param userId
     * @param signature 修改的signature
     * @throws Exception
     */
    void editSignature(Integer userId,String signature)throws Exception;

    /**
     * 编辑用户主页的annoucement
     * @param userId
     * @param annoucement 修改的annoucement
     * @throws Exception
     */
    void editAnouncement(Integer userId,String annoucement)throws Exception;

    /**
     *
     * @param userFontWrite 修改的用户信息，更新数据库中的相应数据
     * @throws Exception
     */
    void update(UserFontWrite userFontWrite)throws Exception;
}
