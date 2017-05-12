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
        if(user.getUsername()!=null){
           Integer id = userReadManage.usernamelogin(user.getUsername(),user.getPassword());
           if(id ==null||id==0||id==-1){
             return   successReturnObject(-1);
           }
          return successReturnObject(id);

        }
        else if (user.getEmail()!=null){
            Integer id = userReadManage.emaillogin(user.getEmail(),user.getPassword());
            if(id ==null||id==0||id==-1){
               return successReturnObject(-1);
            }
           return successReturnObject(id);
        }else {
            return successReturnObject(-1);
        }
//        return successReturnObject(u.getId());
    }
    @RequestMapping(value = "/verifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public  @ResponseBody Object verifyInfo(@RequestBody User user)throws Exception{
        String username=user.getUsername();
        String email=user.getEmail();
//        System.out.println(username+email);
//        //根据manage层传来的is_limit判断isformde 值（is_limit=0,则isform=true,否则为false);
//        boolean isform=true;
//        if(username.equals("zxc")||email.equals("12345@qq.com")){
//            isform=false;
//        }
//        System.out.println(isform);
        boolean isform =  false;
        System.out.println(userReadManage.userValidation(username));
        if(username!=null){
         return successReturnObject(userReadManage.userValidation(username));
        }else if(email!=null){
            return successReturnObject(userReadManage.emailValidation(email));
        }
        return successReturnObject(isform);
    }
}
