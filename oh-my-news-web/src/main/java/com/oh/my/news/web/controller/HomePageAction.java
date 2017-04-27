package com.oh.my.news.web.controller;


import com.oh.my.news.model.home.OthersInfomation;
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
public class HomePageAction extends BaseAction {

//请求userId的信息
    @RequestMapping(value = "/common")
    public @ResponseBody
    Object getInformation(@RequestBody Map userMap) {

    int userId = (Integer) userMap.get("userId");
        System.out.print(userId);
        System.out.print(userMap);
    UserInformation userInformation = null;

        switch(userId)

    {
        case 1:
            userInformation = new UserInformation(1,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D", "zhongzhao84", "goodday", "cool!", 18, 16, "2017.3.15");
//            OthersInfomation othersInfomation1=new OthersInfomation("1","http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105228958_1?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=3gA%2BJohAw18jKqhHSCoyhgMj9MQ%3D","fanfan","funny");

        break;
        case 2:
            userInformation = new UserInformation(2,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D", "fanfan", "good day", "cool cool!", 18, 15, "2017.3.15");
        break;
        default:
            break;

    }
        return successReturnObject(userInformation);

}


    @RequestMapping(value = "/sendInformation")
    public @ResponseBody Object checkSuc(@RequestBody Map userMap){
        int code= (Integer) userMap.get("code");
        int userIdOfLogin;
        int userIdOfShow;

        System.out.println(code +"code");
        switch (code){
            //接收登陆用户userIdOfLogin的signature
            case 0:
                userIdOfLogin=(Integer) userMap.get("userId");
                String signature= (String) userMap.get("signature");
                System.out.print(signature+"signature");
                break;
                //接收登陆用户userIdOfLogin的announcement
            case 1:
                String announcement=(String) userMap.get("announcement");
                System.out.print(announcement+"announcement");
                break;
            //删除登陆用户userIdOfLogin的关注人userIdOfShow
            case 2:
                userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                userIdOfShow=(Integer) userMap.get("userIdOfShow");
                System.out.println(userIdOfShow+"userIdOfShow");
                break;
            //添加登陆用户userIdOfLogin的关注人userIdOfShow
            case 3:
                userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                userIdOfShow=(Integer) userMap.get("userIdOfShow");
                System.out.println(userIdOfShow+"userIdOfShow");
                break;
            //登陆用户userIdOfLogin给userIdOfShow发送私信
            case 4:
                userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                userIdOfShow=(Integer) userMap.get("userIdOfShow");
                System.out.println(userIdOfShow+"userIdOfShow");
                String privateMsg=(String) userMap.get("privateMsg");
                System.out.println(privateMsg +"privateMsg");
            default:
                break;

        }

        return successReturnObject(null);

    }


    @RequestMapping(value = "/getConfirmInfo")
    public @ResponseBody Object getConfirmInfo(@RequestBody Map userMap){
        int userIdOfLogin= (Integer) userMap.get("userIdOfLogin");
        int userIdOfShow= (Integer) userMap.get("userIdOfShow");
        //如果userIdOfShow在userIdOfLogin的关注人列表里，返回0，否则返回1；

        return successReturnObject(0);
    }
}
