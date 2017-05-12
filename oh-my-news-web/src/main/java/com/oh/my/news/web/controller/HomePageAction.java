package com.oh.my.news.web.controller;


import com.oh.my.news.business.read.manage.ConcernReadManage;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.manage.ConcernWriteManage;
import com.oh.my.news.business.write.manage.PrivateMsgWriteManage;
import com.oh.my.news.business.write.manage.UserWriteManage;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.vo.myHomePage.home.UserInformation;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by fanfan on 2017/4/10.
 */
@Controller
@RequestMapping(value = "/homePage")
public class HomePageAction extends BaseAction {
    @Resource
    private UserReadManage userReadManage;
    @Resource
    private UserWriteManage userWriteManage;
    @Resource
    private ConcernWriteManage concernWriteManage;
    @Resource
    private PrivateMsgWriteManage privateMsgWriteManage;
    @Resource
    private ConcernReadManage concernReadManage;

//请求userId的信息
    @RequestMapping(value = "/common")
    public @ResponseBody
    Object getInformation(@RequestBody Map userMap)throws Exception{

        int userId = (Integer) userMap.get("userId");
            UserFont userDetail=userReadManage.getUserDetail(userId);
            System.out.print(userDetail);
            UserInformation user=new UserInformation();
            user.setUsersId(userId);
            user.setAvatarPath(userDetail.getImageUrl());
            user.setAnnouncement(userDetail.getAnnouncement());
            user.setDate(userDetail.getDate());
            user.setFans(userDetail.getFans());
            user.setFollowers(userDetail.getFollowers());
            user.setNickName(userDetail.getNickname());
            user.setSignature(userDetail.getSignature());
            return successReturnObject(user);






}


    @RequestMapping(value = "/sendInformation")
    public @ResponseBody Object checkSuc(@RequestBody Map userMap)throws Exception{
        int code= (Integer) userMap.get("code");
        int userIdOfLogin;
        int userIdOfShow;
            switch (code){
                //接收登陆用户userIdOfLogin的signature
                case 0:
                    userIdOfLogin=(Integer) userMap.get("userId");
                    String signature= (String) userMap.get("signature");
                    userWriteManage.editSignature(userIdOfLogin,signature);
                    break;
                //接收登陆用户userIdOfLogin的announcement
                case 1:
                    userIdOfLogin=(Integer) userMap.get("userId");
                    String announcement=(String) userMap.get("announcement");
                    userWriteManage.editAnouncement(userIdOfLogin,announcement);
                    break;
                //删除登陆用户userIdOfLogin的关注人userIdOfShow
                case 2:
                    userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                    userIdOfShow=(Integer) userMap.get("userIdOfShow");
                    concernWriteManage.deleteFollower(userIdOfLogin,userIdOfShow);
                    break;
                //添加登陆用户userIdOfLogin的关注人userIdOfShow
                case 3:
                    userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                    userIdOfShow=(Integer) userMap.get("userIdOfShow");
                    concernWriteManage.addFollower(userIdOfLogin,userIdOfShow);
                    break;
                //登陆用户userIdOfLogin给userIdOfShow发送私信
                case 4:
                    userIdOfLogin=(Integer)userMap.get("userIdOfLogin");
                    userIdOfShow=(Integer) userMap.get("userIdOfShow");
                    String privateMsg=(String) userMap.get("privateMsg");
                    privateMsgWriteManage.sendMsg(userIdOfLogin,userIdOfShow,privateMsg);
                default:
                    break;
            }
            return successReturnObject("operation success");




    }


    @RequestMapping(value = "/getConfirmInfo")
    public @ResponseBody Object getConfirmInfo(@RequestBody Map userMap) throws Exception{
        int userIdOfLogin= (Integer) userMap.get("userIdOfLogin");
        int userIdOfShow= (Integer) userMap.get("userIdOfShow");
        //如果userIdOfShow在userIdOfLogin的关注人列表里，返回0，否则返回1；
            if(concernReadManage.concernValidation(userIdOfLogin,userIdOfShow))
                return successReturnObject(0);
            else {
                return failReturnObject(1);
            }

    }
}
