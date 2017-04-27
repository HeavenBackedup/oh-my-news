package com.oh.my.news.web.controller;

import com.oh.my.news.model.vo.ConcernUser;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyue on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/myconcern")
public class MyConcernController extends BaseAction{

    /*这个类返回该用户关注的人的列表*/
    @ResponseBody
    @RequestMapping(value = "/getConcernUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getConcernUser(@RequestBody Map inputMap){
        //用户自己的ID
        Integer userId = Integer.parseInt(inputMap.get("userId").toString());

        System.out.println(userId);
        //返回的私信的列表
        List<ConcernUser> concernUserList=new ArrayList<ConcernUser>();

        ConcernUser cu1,cu2,cu3;
        //根据用户ID返回该用户关注的所有人的列表,下面的是我的模拟数据
        cu1=new ConcernUser(1,"DDD","images/hpic.jpeg","上海","少一点套路，多一些真诚");
        cu2=new ConcernUser(2,"EEE","images/hpic.jpeg","上海","少一点套路，多一些真诚");
        cu3=new ConcernUser(3,"FFF","images/hpic.jpeg","上海","少一点套路，多一些真诚");
        concernUserList.add(cu1);
        concernUserList.add(cu2);
        concernUserList.add(cu3);

        System.out.println(concernUserList.size());
        return successReturnObject(concernUserList);
    }

    /*这个类返回该用户关注的某一个人的个人主页*/
    @ResponseBody
    @RequestMapping(value = "/getHomepage",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getHomepage(@RequestBody Map inputMap){
        //请求的用户的ID
        Integer id = Integer.parseInt(inputMap.get("id").toString());

        System.out.println(id);
        //返回个人主页的html
        String url="http:";

        return successReturnObject(url);
    }

}
