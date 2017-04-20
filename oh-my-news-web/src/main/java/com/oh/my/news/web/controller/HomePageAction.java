package com.oh.my.news.web.controller;

import com.oh.my.news.model.home.UserInformation;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fanfan on 2017/4/10.
 */
@Controller
@RequestMapping(value = "/homePage")
public class HomePageAction extends BaseAction{

    @RequestMapping(value = "/common")
    public @ResponseBody Object getInformation(@RequestBody Map userMap){
        int userId =  (Integer) userMap.get("userId");
        System.out.print(userId);
        if (userId!=1){
            return failReturnObject("userId is missing");
        }else{
          List<UserInformation> userInformationList=new ArrayList<UserInformation>();
          userInformationList.add(new UserInformation("http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D","zhongzhao84","goodday","cool!",18,16,"2017.3.15"));

//            System.out.println(userInformationList);
//            Map<String,Object> resMap= new HashMap<String,Object>();
//            resMap.put("avatarPath","http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D");
//            resMap.put("nickName","zhongzhao");
        return successReturnObject(userInformationList);

        }
    }
    @RequestMapping(value = "/sendInformation")
    public @ResponseBody Object checkSuc(@RequestBody Map userMap){
        int userId=(Integer)userMap.get("userId");
        String signature= (String) userMap.get("signature");
        System.out.print(signature);
//        UserInformation userInformation=new UserInformation();
//        UserInformation.setSignature(signature);
        if (userId!=1){
            return failReturnObject("userId is missing");
        }else{
            return successReturnObject(null);
        }

    }
}
