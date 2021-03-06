package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.ConcernReadManage;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.vo.myHomePage.home.OthersInfomation;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Created by fanfan on 2017/4/23.
 */

@Controller
@RequestMapping(value = "/fansPage")
public class FansAction extends BaseAction{
    @Resource
    private ConcernReadManage concernReadManage;

    private Logger logger = Logger.getLogger(FansAction.class);

    @RequestMapping(value = "/getFans")
    public @ResponseBody Object getFansInformation(@RequestBody Map userMap)throws Exception{
        try {
            //获取粉丝列表
            int userId = (Integer) userMap.get("userId");
            List<UserSnapshot> fans=concernReadManage.getMyFans(userId);
            List<OthersInfomation> fansList=new ArrayList<OthersInfomation>();
            for (UserSnapshot fan:fans){
                OthersInfomation item=new OthersInfomation();
                item.setUserId(fan.getId());
                item.setAvatarPath(fan.getImageUrl());
                item.setNickName(fan.getNickname());
                item.setSignature(fan.getSignature());
                if(concernReadManage.concernValidation(userId,fan.getId())){
                    item.setConcernRel(true);
                }else {
                    item.setConcernRel(false);
                }
                fansList.add(item);
            }
            return successReturnObject(fansList);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }


}
