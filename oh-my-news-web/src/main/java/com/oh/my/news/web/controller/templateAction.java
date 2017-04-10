package com.oh.my.news.web.controller;

import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by shj on 2017/4/11.
 */
@Controller
@RequestMapping(value = "/template")
public class templateAction extends BaseAction {


    @RequestMapping(value = "/getInput",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object getInput(@RequestBody Map inputMap){
        System.out.println(inputMap);
        String input = inputMap.get("value").toString();
        String res = "data is recieved,repeat the data: "+input;
        return successReturnObject(res);
    }
}
