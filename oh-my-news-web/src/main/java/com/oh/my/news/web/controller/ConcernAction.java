package com.oh.my.news.web.controller;

import com.oh.my.news.model.vo.myHomePage.home.OthersInfomation;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fanfan on 2017/4/26.
 */
@Controller
@RequestMapping(value = "/concernPage")
public class ConcernAction extends BaseAction{


    @RequestMapping(value = "/getConcern")
    public @ResponseBody
    Object getFansInformation(@RequestBody Map userMap){

        int userId = (Integer) userMap.get("userId");
        System.out.println("数据库接收到的concern的请求数据"+userMap);

        List<OthersInfomation> concernList=new ArrayList<OthersInfomation>();
        OthersInfomation othersInfomation1=new OthersInfomation(2,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D","fanfan","good day");
        OthersInfomation othersInfomation2=new OthersInfomation(3,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105281826_2?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=%2B3Q2dKk8KlxgAwkEkh8yAFxQq1o%3D","nanan","bad day!");


        OthersInfomation othersInfomation3=new OthersInfomation(1,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D","zhongzhao84","goodday");


        //返回userId的关注人的列表
        switch (userId){
            case 1:
                concernList.add(othersInfomation1);
                concernList.add(othersInfomation2);
                break;
            case 2:
                concernList.add(othersInfomation3);
                concernList.add(othersInfomation2);
                break;
            default:
                break;
        }
        return successReturnObject(concernList);
    };

}
