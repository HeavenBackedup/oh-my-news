package com.oh.my.news.web.controller;

import com.oh.my.news.model.dto.Wallet;
import com.oh.my.news.web.util.BaseAction;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
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
                Date rightnow=new Date();
                SimpleDateFormat dataformat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Random random=new Random();
                int id=random.nextInt(10000);
                Map<String,Object> map=new HashMap<String, Object>();
                List<Wallet> list=new ArrayList<Wallet>();
                list.add(new Wallet(dataformat.format(rightnow),"提现",inputMap.get("value").toString(),"自己用户名和ID","",id));
                map.put("myWallet",list);
                System.out.println(map);

                return successReturnObject(map);
        }


        @RequestMapping(value = "/getIncomeevents",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getIncomeevents(@RequestBody Map inputMap) {
                System.out.println(inputMap);
                Date rightnow=new Date();
                SimpleDateFormat dataformat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Random random=new Random();
                int id=random.nextInt(10000);
                Map<String,Object> map=new HashMap<String, Object>();
                List<Wallet> list=new ArrayList<Wallet>();
                list.add(new Wallet(dataformat.format(rightnow),"充值",inputMap.get("value").toString(),"自己用户名和ID","",id));
                map.put("myWallet",list);
                return successReturnObject(map);
        }
}
