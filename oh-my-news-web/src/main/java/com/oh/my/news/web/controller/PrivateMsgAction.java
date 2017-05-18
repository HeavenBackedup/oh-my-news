package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.PrivateMsgReadManage;
import com.oh.my.news.business.write.manage.PrivateMsgWriteManage;
import com.oh.my.news.model.dto.PrivateMessage;
import com.oh.my.news.model.vo.PrivateMsg;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

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
    private static Logger logger = Logger.getLogger(PrivateMsgAction.class);
    @ResponseBody
    @RequestMapping(value = "/getPrivateMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getPrivateMsg(@RequestBody Map inputMap) throws Exception{
        try {
            Integer userId = Integer.parseInt(inputMap.get("userId").toString());
            Integer selectedValue = Integer.parseInt(inputMap.get("selectedValue").toString());
            List<PrivateMsg> privateMsgList=new ArrayList<PrivateMsg>();

            PrivateMsg pm1,pm2,pm3;
            switch (selectedValue){
                case 0:
                    return successReturnObject(covertPrivateMessageToPrivateMsg(privateMsgReadManage.getUnReadedPrivateMsg(userId)));
                case 1:
                    return successReturnObject(covertPrivateMessageToPrivateMsg(privateMsgReadManage.getReadedPrivateMsg(userId)));
                case 2:
                    return successReturnObject(covertPrivateMessageToPrivateMsg(privateMsgReadManage.getPrivateMsg(userId)));
            }
            return failReturnObject("读取私信失败");
        }catch (Exception e){
            logger.error(e);
            throw e;
        }
        //用户自己的ID

//        return successReturnObject(privateMsgList);
    }

    private List<PrivateMsg> covertPrivateMessageToPrivateMsg(List<PrivateMessage> privateMessages){
        List<PrivateMsg> privateMsgs = new ArrayList<PrivateMsg>();
        for(PrivateMessage p:privateMessages){
            PrivateMsg privateMsg = new PrivateMsg();
            privateMsg.setId(p.getId());
            privateMsg.setAvatar(p.getImageUrl());
            privateMsg.setMessage(p.getContent());
            privateMsg.setTime(p.getDate());
            privateMsg.setUsername(p.getSourceUsername());
            privateMsg.setUserId(p.getUserId());
            privateMsgs.add(privateMsg);
        }
        return privateMsgs;

    }


    /*这个方法返回用户自己和某一个人对话的所有的私信的列表。
      同样也要按照时间进行排序，最新的在前面*/
    @ResponseBody
    @RequestMapping(value = "/getExMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getExMsg(@RequestBody Map inputMap)throws Exception{
        try {
            //用户自己的ID
            Integer myUserId = Integer.parseInt(inputMap.get("userId").toString());

            //和我发私信交流的另一个用户的ID
            Integer otherUserId=Integer.parseInt(inputMap.get("otherUserId").toString());
            //返回的私信的列表
            return successReturnObject(covertPrivateMessageToPrivateMsg(privateMsgReadManage.getExMsg(otherUserId,myUserId)));
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/getAndroidExMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getAndroidExMsg(@RequestBody Map inputMap)throws Exception{
        try {
            //用户自己的ID
            Integer myUserId = Integer.parseInt(inputMap.get("userId").toString());

            //和我发私信交流的另一个用户的ID
            Integer otherUserId=Integer.parseInt(inputMap.get("otherUserId").toString());
            return privateMsgReadManage.getExMsgALl(otherUserId,myUserId);
//
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    /*用户发送一条私信，新私信成功存入数据库返回true，否则返回false*/
    @ResponseBody
    @RequestMapping(value = "/postPrivateMsg",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object postPrivateMsg(@RequestBody Map inputMap)throws Exception{
        try {
            //用户自己的ID
            Integer myUserId = Integer.parseInt(inputMap.get("userId").toString());
            //和我发私信交流的另一个用户的ID
            Integer otherUserId=Integer.parseInt(inputMap.get("otherUserId").toString());
            //私信
            String privateMsg=inputMap.get("privateMsg").toString();
            //存入数据库
            //成功返回true。失败返回false。
            privateMsgWriteManage.sendMsg(myUserId,otherUserId,privateMsg);
            return successReturnObject(true);
        }


        catch (Exception e){

        logger.error(e);
        throw e;
    }



}}
