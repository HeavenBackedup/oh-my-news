package com.oh.my.news.web.controller;


import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.po.UserWrite;
import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;
import com.sun.javafx.collections.MappingChange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

import static com.oh.my.news.web.util.BaseAction.APPLICATION_JSON;

/**
 * Created by llf on 2017/4/16.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterAction extends BaseAction {
    @Autowired
    private UserWriteManage userWriteManage;
    @Autowired
    private UserReadManage userReadManage;

    private Logger logger = Logger.getLogger(RegisterAction.class);

    @RequestMapping(value = "/submitInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object submitInfo(@RequestBody User user)throws Exception{
        try {
            UserWrite userWrite = new UserWrite();
            userWrite.setDate(new Date());
            userWrite.setUsername(user.getUsername());
            userWrite.setEmail(user.getEmail());
            userWrite.setPassword(user.getPassword());
            userWrite.setNickname(user.getUsername());
            userWriteManage.register(userWrite);

            return successReturnObject(true);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

//        boolean isform=false;
//        System.out.println("success");
//        User u = new User();
//        u.setUsername(user.getUsername());
//        u.setPassword(user.getPassword());
//        u.setEmail(user.getEmail());
//        System.out.println(u.getUsername() + " " + u.getPassword()+" "+u.getEmail());
//        if (u != null) {
//            isform=true;
//        }
//
//        return successReturnObject(isform);
    }

    @RequestMapping(value = "/verifynameInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object verifynameInfo(@RequestBody Map map)throws Exception {
        try {

            String username = map.get("value").toString();
            boolean isform = userReadManage.userValidation(username);
//        boolean isform = true;
//        String inputusername = map.get("value").toString();
//        if (inputusername.equals("abc")) {
//            isform = false;
//        }
            return successReturnObject(!isform);
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }

    }


    @RequestMapping(value = "/verifyemailInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public  @ResponseBody Object verifyemailInfo(@RequestBody Map map)throws Exception{
        boolean isform=true;
        String email=map.get("value").toString();

        isform = userReadManage.emailValidation(email);
//        if(inputemail.equals("123@qq.com")){
//            isform=false;
//        }
        return successReturnObject(!isform);
    }

    @RequestMapping(value = "/androidSubmitInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object androidSubmitInfo(@RequestBody Map map)throws Exception{
        try {
            String username = (String) map.get("username");
            String pwd = (String)map.get("pwd");
            if(userReadManage.userValidation(username))
                return successReturnObject(false);
            UserWrite userWrite = new UserWrite();
            userWrite.setDate(new Date());
            userWrite.setNickname(username);
            userWrite.setUsername(username);
            userWrite.setPassword(pwd);
            userWrite.setDate(new Date());
//        userWrite.setUsername(user.getUsername());
//        userWrite.setEmail(user.getEmail());
//        userWrite.setPassword(user.getPassword());
//        userWrite.setNickname(user.getUsername());
            userWriteManage.register(userWrite);
            return successReturnObject(true);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }
}
