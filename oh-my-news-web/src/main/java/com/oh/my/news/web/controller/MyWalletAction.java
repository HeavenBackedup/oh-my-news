package com.oh.my.news.web.controller;

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

        @RequestMapping(value = "/getWithdraw",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getWithdraw(@RequestBody Map inputMap) {
                float rmb=0;
                rmb = (float) Integer.parseInt(inputMap.get("value").toString());
                return rmb;
        }
        @RequestMapping(value = "/getRecharge",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getRecharge(@RequestBody Map inputMap) {
                float dollar=0;
                dollar = (float) Integer.parseInt(inputMap.get("value").toString());

                return dollar;
        }

        @RequestMapping(value = "/getPayevents",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getPayevents(@RequestBody Map inputMap) {
                long time=0;
                String goal="";
                String sum="";
                String person="";
                String note="";
                int id=0;
                Random random=new Random();

                List<Map<String,Object>> events=new ArrayList();
                Map<String,Object> event=new HashMap<String,Object>();
                Calendar rightnow=Calendar.getInstance();
                time=rightnow.getTimeInMillis();
                goal="提现";
                sum="提现金额";
                person="自己用户名和id";
                note="";
                id=random.nextInt(10000);
                event.put("1",time);
                event.put("2",goal);
                event.put("3",sum);
                event.put("4",person);
                event.put("5",note);
                event.put("6",id);
                events.add(event);
                return events;
        }


        @RequestMapping(value = "/getIncomeevents",consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public @ResponseBody Object getIncomeevents(@RequestBody Map inputMap) {
                long time=0;
                String goal="";
                String sum="";
                String person="";
                String note="";
                int id=0;
                Random random=new Random();

                List<Map<String,Object>> events=new ArrayList();
                Map<String,Object> event=new HashMap<String,Object>();
                Calendar rightnow=Calendar.getInstance();
                time=rightnow.getTimeInMillis();
                goal="充值";
                sum="充值金额";
                person="自己用户名和id";
                note="";
                id=random.nextInt(10000);
                event.put("1",time);
                event.put("2",goal);
                event.put("3",sum);
                event.put("4",person);
                event.put("5",note);
                event.put("6",id);
                events.add(event);

                return events;




        }




}
