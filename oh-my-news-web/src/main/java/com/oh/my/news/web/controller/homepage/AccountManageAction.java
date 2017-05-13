package com.oh.my.news.web.controller.homepage;

import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.dto.UserFontWrite;
import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.BeanProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.SavepointManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyan on 2017/4/19.
 */
@Controller
@RequestMapping(value = "/accountManage")
public class AccountManageAction extends BaseAction{

    @Autowired
    private UserReadManage userReadManage;
    @Autowired
    private UserWriteManage userWriteManage;

    private static Logger logger = Logger.getLogger(AccountManageAction.class);

    @ResponseBody
    @RequestMapping(value = "/getUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getUser(@RequestBody Map userIdMap)throws Exception{
        try {
            int userId = Integer.parseInt(userIdMap.get("userId").toString().trim());
            UserFont userFont =  userReadManage.getUserDetail(userId);
            Map<String,Object> userList = new HashMap<String, Object>();
            userList.put("username",userFont.getNickname());
            userList.put("url",userFont.getImageUrl());
            userList.put("address",userFont.getAddress());
            userList.put("email",userFont.getEmail());
            userList.put("password",userFont.getPassword());
            userList.put("photoid",userReadManage.getMediaId(userId));
            return successReturnObject(userList);

        }catch (Exception e){
            logger.error(e);
            throw e;
        }


    }

    @ResponseBody
    @RequestMapping(value = "/getVerifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public Object getVerifyInfo(@RequestBody Map usernameMap){
        return successReturnObject(true);
    }

    @ResponseBody
    @RequestMapping(value = "/getInputUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getInputUser(@RequestBody User user)throws Exception{
        try {
            UserFontWrite userFontWrite = new UserFontWrite();
            UserFont userFont = userReadManage.getUserDetail(user.getId());
            BeanUtils.copyProperties(userFont,userFontWrite);
            userFontWrite.setNickname(user.getUsername());
            userFontWrite.setAddress(user.getAddress());
            userFontWrite.setMedia_id(Integer.parseInt(user.getPhotoid()));
            userFontWrite.setEmail(user.getEmail());
            userFontWrite.setPassword(user.getPassword());
            userWriteManage.update(userFontWrite);
            return successReturnObject(true);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }



    }

}
