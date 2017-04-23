package com.oh.my.news.web.controller;


import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.oh.my.news.web.util.BaseAction.APPLICATION_JSON;

/**
 * Created by llf on 2017/4/16.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterAction extends BaseAction {

    @RequestMapping(value = "/submitInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object submitInfo(@RequestBody User user) {
        boolean isform=false;
        System.out.println("success");
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        System.out.println(u.getUsername() + " " + u.getPassword()+" "+u.getEmail());
        if (u != null) {
            isform=true;
        }
        return successReturnObject(isform);
    }

    @RequestMapping(value = "/verifyInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object verifyInfo(@RequestBody Map map) {
        boolean isform = true;
        String inputusername = map.get("value").toString();
        if (inputusername.equals("abc")) {
            isform = false;
        }
        return successReturnObject(isform);
    }
}
