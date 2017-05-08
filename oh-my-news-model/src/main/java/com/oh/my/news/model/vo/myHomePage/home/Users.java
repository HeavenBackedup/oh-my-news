package com.oh.my.news.model.vo.myHomePage.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanfan on 2017/4/23.
 */
public interface Users {

    Map<Integer,UserInformation> usersMap=new HashMap<Integer,UserInformation>();

    List<UserInformation> userList=new ArrayList<UserInformation>();
//    UserInformation userInformation1 = new UserInformation(1,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D", "zhongzhao84", "goodday", "cool!", 18, 16, "2017.3.15");


}
