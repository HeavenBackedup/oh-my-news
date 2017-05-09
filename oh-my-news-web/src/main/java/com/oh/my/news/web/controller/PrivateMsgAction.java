package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.PrivateMsgReadManage;
import com.oh.my.news.business.write.manage.PrivateMsgWriteManage;
import com.oh.my.news.model.vo.PrivateMsg;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyue on 2017/4/20.
 */
@Controller
@RequestMapping(value = "/privatemsg")
public class PrivateMsgAction extends BaseAction{
    @Autowired
    private PrivateMsgReadManage privateMsgReadManage;

    @Autowired
    private PrivateMsgWriteManage privateMsgWriteManage;
    /*这个方法返回用户自己的所有私信对象的一个列表，
    私信的内容是最近的一条。另外列表要按照时间进行排序，
    最新的私信在最前面。*/
    @ResponseBody
    @RequestMapping(value = "/getPrivateMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getPrivateMsg(@RequestBody Map inputMap) throws Exception{
        //用户自己的ID
        Integer userId = Integer.parseInt(inputMap.get("userId").toString());

        //这个变量是用户请求的私信列表的类型
        //0：未读私信列表，1：已读私信列表，2：全部私信列表
//        Integer selectedValue=999;
        Integer selectedValue = Integer.parseInt(inputMap.get("selectedValue").toString());
//        selectedValue=inputMap.get("selectedValue").toString();
        System.out.println(userId+"...."+selectedValue);
        //返回的私信的列表
        List<PrivateMsg> privateMsgList=new ArrayList<PrivateMsg>();

        PrivateMsg pm1,pm2,pm3;
        //根据用户请求的私信列表的类型返回对应的私信列表,下面的是我的模拟数据
//        if(selectedValue==0){
//            pm1=new PrivateMsg(1,"AAA","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm2=new PrivateMsg(2,"BBB","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm3=new PrivateMsg(3,"CCC","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            privateMsgList.add(pm1);
//            privateMsgList.add(pm2);
//            privateMsgList.add(pm3);
//        }else if(selectedValue==1){
//            pm1=new PrivateMsg(2,"BBB","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm2=new PrivateMsg(1,"AAA","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm3=new PrivateMsg(3,"CCC","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            privateMsgList.add(pm1);
//            privateMsgList.add(pm2);
//            privateMsgList.add(pm3);
//        }else{
//            pm1=new PrivateMsg(3,"CCC","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm2=new PrivateMsg(2,"BBB","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            pm3=new PrivateMsg(1,"AAA","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//            privateMsgList.add(pm1);
//            privateMsgList.add(pm2);
//            privateMsgList.add(pm3);
//        }
//        System.out.println(privateMsgList.size());
        switch (selectedValue){
            case 0:
                return successReturnObject(privateMsgReadManage.getPrivateMsg(userId));
            case 1:
                return successReturnObject(privateMsgReadManage.getReadedPrivateMsg(userId));
            case 2:
                return successReturnObject(privateMsgReadManage.getUnReadedPrivateMsg(userId));
        }
        return failReturnObject("读取私信失败");
//        return successReturnObject(privateMsgList);
    }


    /*这个方法返回用户自己和某一个人对话的所有的私信的列表。
      同样也要按照时间进行排序，最新的在前面*/
    @ResponseBody
    @RequestMapping(value = "/getExMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getExMsg(@RequestBody Map inputMap)throws Exception{
        //用户自己的ID
        Integer myUserId = Integer.parseInt(inputMap.get("userId").toString());

        //和我发私信交流的另一个用户的ID
        Integer otherUserId=Integer.parseInt(inputMap.get("otherUserId").toString());
        System.out.println(myUserId+"...."+otherUserId);
        //返回的私信的列表
//        List<PrivateMsg> privateMsgList=new ArrayList<PrivateMsg>();
//
//        //我的模拟数据
//        PrivateMsg pm1=new PrivateMsg(1,"AAA","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//        PrivateMsg pm2=new PrivateMsg(2,"BBB","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//        PrivateMsg pm3=new PrivateMsg(3,"CCC","images/hpic.jpeg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum","20170423");
//        privateMsgList.add(pm1);
//        privateMsgList.add(pm2);
//        privateMsgList.add(pm3);
//
//        System.out.println(privateMsgList.size());



        return successReturnObject(privateMsgReadManage.getExMsg(otherUserId,myUserId));
    }

    /*用户发送一条私信，新私信成功存入数据库返回true，否则返回false*/
    @ResponseBody
    @RequestMapping(value = "/postPrivateMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object postPrivateMsg(@RequestBody Map inputMap)throws Exception{
        //用户自己的ID
        Integer myUserId = Integer.parseInt(inputMap.get("userId").toString());

        //和我发私信交流的另一个用户的ID
        Integer otherUserId=Integer.parseInt(inputMap.get("otherUserId").toString());

        //私信
        String privateMsg=inputMap.get("privateMsg").toString();

        System.out.println(myUserId+"...."+otherUserId+"..."+privateMsg);
        //存入数据库

        //成功返回true。失败返回false。
        privateMsgWriteManage.sendMsg(myUserId,otherUserId,privateMsg);
        return successReturnObject(true);
    }

}
