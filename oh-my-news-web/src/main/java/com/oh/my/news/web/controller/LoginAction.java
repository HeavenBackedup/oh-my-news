package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.oh.my.news.web.util.BaseAction.APPLICATION_JSON;

/**
 * Created by llf on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginAction extends BaseAction {
    @Autowired
    private UserReadManage userReadManage;

    @RequestMapping(value = "/submitInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object submitInfo(@RequestBody User user)throws Exception {

//        User u = new User();
//        u.setEmail(user.getEmail());
//        u.setUsername(user.getUsername());
//        u.setPassword(user.getPassword());
//        System.out.println(u.getUsername() + " " + u.getPassword() + " " + u.getEmail());
//        if (u.getPassword().equals("123456") && u.getEmail().equals("1234567@qq.com")) {
//           u.setId(-1);
//        }else{
//            u.setId(1);
//        }
        if(user.getUsername()!=null)
            return successReturnObject(userReadManage.usernamelogin(user.getUsername(),user.getPassword()));
        else if (user.getEmail()!=null){
            return successReturnObject(userReadManage.emaillogin(user.getEmail(),user.getPassword()));
        }else {
            throw new Exception("username and email is null");
        }
//        return successReturnObject(u.getId());
    }
    @RequestMapping(value = "/verifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public  @ResponseBody Object verifyInfo(@RequestBody User user) throws Exception{
        boolean isform=true;
        String username=user.getUsername();
        String email=user.getEmail();
        //根据manage层传来的is_limit判断isformde 值（is_limit=0,则isform=true,否则为false);
        System.out.println(username+" "+email);
        if(username==""&&email==""){
            isform=true;
        }else{

            Integer status=userReadManage.getUserLimit(username,email);
            System.out.println(status);
            if(status==1||status==2){
                isform=false;
            }
        }

        System.out.println(isform);
        return successReturnObject(isform);
    }
}
