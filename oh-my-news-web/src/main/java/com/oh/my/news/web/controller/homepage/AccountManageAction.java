package com.oh.my.news.web.controller.homepage;

import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.dto.UserFontWrite;
import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;
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

    @ResponseBody
    @RequestMapping(value = "/getUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getUser(@RequestBody Map userIdMap)throws Exception{
//        String userId = userIdMap.get("userId").toString();
//        Map<String,Object> userList = new HashMap<String, Object>();
//        String address[] = new String[]{"北京","北京","朝阳区"};
//        //根据userId从数据库获取用户的初始数据
//        if("123".equals(userId)) {
//            userList.put("username","123");
//            userList.put("url","images/example.jpg");
//            userList.put("address",address);
//            userList.put("email","345678910@qq.com");
//        }
//        System.out.print(userList);

        int userId = Integer.parseInt(userIdMap.get("userId").toString().trim());
        System.out.println("getUser"+userId);
        UserFont userFont =  userReadManage.getUserDetail(userId);
        Map<String,Object> userList = new HashMap<String, Object>();
        userList.put("username",userFont.getNickname());
        userList.put("url",userFont.getImageUrl());
        userList.put("address",userFont.getAddress());
        userList.put("email",userFont.getEmail());
        userList.put("password",userFont.getPassword());
        System.out.println(userFont);
        System.out.println(userReadManage.getMediaId(userId));
        userList.put("photoid",userReadManage.getMediaId(userId));
        return successReturnObject(userList);

    }

    @ResponseBody
    @RequestMapping(value = "/getVerifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public Object getVerifyInfo(@RequestBody Map usernameMap){
//        boolean isExitUsername = false;
//        String username = usernameMap.get("username").toString();
        //对比数据库，用户名是否已存在
//        if ("123".equals(username)){
//            isExitUsername=false;
//        }else {
//            isExitUsername=true;
//        }
//        return successReturnObject(isExitUsername);
        return successReturnObject(true);
    }

    @ResponseBody
    @RequestMapping(value = "/getInputUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getInputUser(@RequestBody User user)throws Exception{
//        boolean isTrue=false;

        //修改信息存入数据库,成功（失败）返回true（false）
//        User u = new User();
//        u.setUsername(user.getUsername());
//        u.setPassword(user.getPassword());
//        System.out.println(user.getUsername());
//
//        if("123".equals(user.getUsername())){
//            isTrue=true;
//        }
//        System.out.println(isTrue);
//        return successReturnObject(isTrue);
        System.out.println(user);
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


    }

}
