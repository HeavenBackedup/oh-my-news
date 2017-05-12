package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.PrivateMsgReadManage;
import com.oh.my.news.business.write.manage.PrivateMsgWriteManage;
import com.oh.my.news.model.dto.PrivateMessage;
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
        List<PrivateMessage> messages=new ArrayList<PrivateMessage>();
        switch (selectedValue){
            case 0:
                messages=privateMsgReadManage.getUnReadedPrivateMsg(userId);
//                System.out.println(messages);
                for(PrivateMessage message:messages){
                    PrivateMsg items=new PrivateMsg();
                    items.setId(message.getId());
                    items.setAvatar(message.getImageUrl());
                    items.setMessage(message.getContent());
                    items.setTime(message.getDate());
                    items.setUsername(message.getSourceUsername());
                    privateMsgList.add(items);
                }
                System.out.println(privateMsgList);
                return successReturnObject(privateMsgList);

            case 1:
                messages=privateMsgReadManage.getReadedPrivateMsg(userId);
                for(PrivateMessage message:messages){
                    PrivateMsg items=new PrivateMsg();
                    items.setId(message.getId());
                    items.setAvatar(message.getImageUrl());
                    items.setMessage(message.getContent());
                    items.setTime(message.getDate());
                    items.setUsername(message.getSourceUsername());
                    privateMsgList.add(items);
                }
                return successReturnObject(privateMsgList);

            case 2:
                messages=privateMsgReadManage.getPrivateMsg(userId);
                for(PrivateMessage message:messages){
                    PrivateMsg items=new PrivateMsg();
                    items.setId(message.getId());
                    items.setAvatar(message.getImageUrl());
                    items.setMessage(message.getContent());
                    items.setTime(message.getDate());
                    items.setUsername(message.getSourceUsername());
                    privateMsgList.add(items);
                }
                return successReturnObject(privateMsgList);

        }
        return failReturnObject("读取私信失败");
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
        List<PrivateMessage> privateMessages = privateMsgReadManage.getExMsg(otherUserId,myUserId);
        List<PrivateMsg> privateMsgs = new ArrayList<PrivateMsg>();
        for(PrivateMessage message:privateMessages){
            PrivateMsg items=new PrivateMsg();
            items.setId(message.getId());
            items.setAvatar(message.getImageUrl());
            items.setMessage(message.getContent());
            items.setTime(message.getDate());
            items.setUsername(message.getSourceUsername());
            privateMsgs.add(items);
        }
        return successReturnObject(privateMsgs);
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
