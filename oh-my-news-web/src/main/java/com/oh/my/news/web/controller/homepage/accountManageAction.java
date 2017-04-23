package com.oh.my.news.web.controller.homepage;

import com.oh.my.news.model.vo.User;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.SavepointManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyan on 2017/4/19.
 */
@Controller
@RequestMapping(value = "/accountManage")
public class accountManageAction extends BaseAction{

    @ResponseBody
    @RequestMapping(value = "/getUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getUser(@RequestBody Map userIdMap){
        String userId = userIdMap.get("userId").toString();
        Map<String,Object> userList = new HashMap<String, Object>();
        String address[] = new String[]{"北京","北京","朝阳区"};
        //根据userId从数据库获取用户的初始数据
        if("123".equals(userId)) {
            userList.put("username","123");
            userList.put("url","images/example.jpg");
            userList.put("address",address);
            userList.put("email","345678910@qq.com");
        }
        System.out.print(userList);
        return successReturnObject(userList);

    }

    @ResponseBody
    @RequestMapping(value = "/getVerifyInfo",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public Object getVerifyInfo(@RequestBody Map usernameMap){
        boolean isExitUsername = false;
        String username = usernameMap.get("username").toString();
        //对比数据库，用户名是否已存在
//        if ("123".equals(username)){
//            isExitUsername=false;
//        }else {
//            isExitUsername=true;
//        }
        return successReturnObject(isExitUsername);
    }

    @ResponseBody
    @RequestMapping(value = "/getInputUser",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public Object getInputUser(@RequestBody User user){
        boolean isTrue=false;

        //修改信息存入数据库,成功（失败）返回true（false）
//        User u = new User();
//        u.setUsername(user.getUsername());
//        u.setPassword(user.getPassword());

        System.out.println(user.getUsername());
        if("123".equals(user.getUsername())){
            isTrue=true;
        }
        System.out.println(isTrue);
        return successReturnObject(isTrue);

    }

}
