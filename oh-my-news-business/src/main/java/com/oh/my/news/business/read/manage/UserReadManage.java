package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.dto.UserSnapshot;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface UserReadManage {
    /**
     *
     * @param username
     * @param password
     * @return  登录成功返回用户的useId
     * @throws Exception
     */
    Integer usernamelogin(String username,String password)throws Exception;
    /**
     *
     * @param email
     * @param password
     * @return  登录成功返回用户的useId
     * @throws Exception
     */
    Integer emaillogin(String email,String password) throws Exception;
    /**
     *
     * @param username  使用用户名进行验证
     * @return
     * @throws Exception
     */
    boolean userValidation(String username)throws Exception;

    /**
     *
     * @param email  使用邮箱进行验证
     * @return
     * @throws Exception
     */
    boolean emailValidation(String email)throws Exception;


    /**
     *
     * @param userId
     * @return  用户的相关信息 包括关注人数跟粉丝人数
     * @throws Exception
     */
    UserFont getUserDetail(int userId)throws Exception;
}
