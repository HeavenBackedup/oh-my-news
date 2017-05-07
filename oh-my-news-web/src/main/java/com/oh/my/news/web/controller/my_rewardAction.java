package com.oh.my.news.web.controller;

import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.oh.my.news.web.util.BaseAction.APPLICATION_JSON;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
@RequestMapping(value="/my_reward")
public class my_rewardAction extends BaseAction {
    @RequestMapping(value = "/getInput", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object getInput(@RequestBody Map inputMap) {
        float total=1000;
        float ballance=0;

        String res="";
        System.out.println(inputMap);
        float reward=(float)Integer.parseInt(inputMap.get("value").toString());
        List<Float> Reward=new ArrayList();
        Reward.add(reward);
        if(reward>1000){

             res="您的打赏超出额度";
        }
        if(reward<=1000) {
            for(int i=0;i<Reward.size();i++){
            ballance=total-Reward.get(i);
                System.out.println(Reward);
            }
            res = "已收到您的打赏，您的账户余额为:" +ballance;


        }

        return successReturnObject(res);
    }





}
