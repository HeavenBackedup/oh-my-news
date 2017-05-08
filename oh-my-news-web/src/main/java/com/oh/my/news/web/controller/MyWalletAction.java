package com.oh.my.news.web.controller;

import com.oh.my.news.model.dto.Wallet;
import com.oh.my.news.web.util.BaseAction;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2017/4/23.
 */

@Controller
@RequestMapping(value = "/mywallet")
public class MyWalletAction extends BaseAction{

        @RequestMapping(value = "/getPayevents",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getPayevents(@RequestBody Map inputMap) {
                System.out.println(inputMap);
                Calendar rightnow=Calendar.getInstance();
                Random random=new Random();
                int id=random.nextInt(10000);
                Map<String,Object> map=new HashMap<String, Object>();
                List<Wallet> list=new ArrayList<Wallet>();
                list.add(new Wallet(rightnow.getTimeInMillis(),"提现",inputMap.get("rmb").toString(),"自己用户名和ID","",id));
                map.put("myWallet",list);
                return map;
        }


        @RequestMapping(value = "/getIncomeevents",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getIncomeevents(@RequestBody Map inputMap) {
                System.out.println(inputMap);
                Calendar rightnow=Calendar.getInstance();
                Random random=new Random();
                int id=random.nextInt(10000);
                Map<String,Object> map=new HashMap<String, Object>();
                List<Wallet> list=new ArrayList<Wallet>();
                list.add(new Wallet(rightnow.getTimeInMillis(),"充值",inputMap.get("rmb").toString(),"自己用户名和ID","",id));
                map.put("myWallet",list);
                return map;
        }
}
