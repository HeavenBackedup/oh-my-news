package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import static com.oh.my.news.web.util.BaseAction.APPLICATION_JSON;

/**
 * Created by llf on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginAction extends BaseAction {
    @Autowired
    private UserReadManage userReadManage;
    private Logger logger =Logger.getLogger(LoginAction.class);

    @RequestMapping(value = "/submitInfo", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object submitInfo(@RequestBody User user)throws Exception {
        try {
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
        }catch (Exception e){
            logger.error(e);
            throw e;
        }


//        return successReturnObject(u.getId());
    }
    @RequestMapping(value = "/verifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public  @ResponseBody Object verifyInfo(@RequestBody User user) throws Exception{
        try {
            boolean isform=true;
            String username=user.getUsername();
            String email=user.getEmail();
            //根据manage层传来的is_limit判断isformde 值（is_limit=0,则isform=true,否则为false);
            if((username==""||username==null)&&(email==""||email==null)){
                isform=true;
            }else{

                Integer status=userReadManage.getUserLimit(username,email);
                if(status==1||status==2){
                    isform=false;
                }
            }
            return successReturnObject(isform);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }
}
