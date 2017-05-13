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
import java.util.List;
import java.util.Map;

/**
 * Created by fanfan on 2017/4/26.
 */
@Controller
@RequestMapping(value = "/concernPage")
public class ConcernAction extends BaseAction{

    @Resource
    private ConcernReadManage concernReadManage;

    private Logger logger = Logger.getLogger(ConcernAction.class);

    @RequestMapping(value = "/getConcern")
    public @ResponseBody
    Object getFansInformation(@RequestBody Map userMap) throws Exception {
        try {
            //获取关注人列表
            int userId = (Integer) userMap.get("userId");
            List<UserSnapshot> concerns = concernReadManage.getMyConcerns(userId);
            List<OthersInfomation> concernList = new ArrayList<OthersInfomation>();
            for (UserSnapshot u : concerns) {
                OthersInfomation item = new OthersInfomation();
                item.setUserId(u.getId());
                item.setAvatarPath(u.getImageUrl());
                item.setNickName(u.getNickname());
                item.setSignature(u.getSignature());
                concernList.add(item);
            }
            return successReturnObject(concernList);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }



    }

}
