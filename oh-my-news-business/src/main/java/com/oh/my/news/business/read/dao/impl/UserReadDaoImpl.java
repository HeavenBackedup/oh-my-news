package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.model.dto.UserDto;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.User;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by llf on 2017/5/4.
 */
@Repository
public class UserReadDaoImpl implements UserReadDao{
    @Autowired
    @Qualifier(value="sqlMapClientRead")
    private SqlMapClient sqlMapClient;
    public Integer verifyUserbyuername(String username) throws Exception {
        return (Integer) sqlMapClient.queryForObject("user_sqlMap.verify_username",username);
    }

    public Integer verifyUserbyemail(String email) throws Exception {
        return (Integer) sqlMapClient.queryForObject("user_sqlMap.verify_email",email);
    }

    public Integer queryUserbyusername(String username,String password) throws Exception {
        Integer result=-1;
        Map<String,Object> map=new HashedMap();
        map.put("username",username);
        map.put("password",password);
        result =(Integer)sqlMapClient.queryForObject("user_sqlMap.username_query_user",map);
        if(result!=null){
            return  result;
        }
        else {
            return -1;
        }
    }

    public Integer queryUserbyemail(String email,String password) throws Exception {
        Integer result=-1;
        Map<String,Object> map=new HashedMap();
        map.put("email",email);
        map.put("password",password);
        result=(Integer)sqlMapClient.queryForObject("user_sqlMap.email_query_user",map);
        if(result!=null){
            return result;
        }
        else {
            return -1;
        }
    }

    public UserDto queryUserDetail(int userId) throws Exception {
        User u=(User)sqlMapClient.queryForObject("user_sqlMap.query_user_detail",userId);
        int followers=(Integer) sqlMapClient.queryForObject("user_sqlMap.calculate_followers",userId);
        int fans=(Integer) sqlMapClient.queryForObject("user_sqlMap.calculate_fans",userId);
        UserDto user=new UserDto();
        user.setId(u.getId());
//        System.out.println(user.getId());
        user.setUsername(u.getUsername());
//        System.out.println(user.getUsername());
        user.setEmail(u.getEmail());
        user.setSignature(u.getSignature());
//        System.out.println(user.getEmail());
        user.setAddress(u.getAddress());
        user.setAnnouncement(u.getAnnouncement());
        user.setImageUrl(u.getImageUrl());
        user.setDate(u.getDate());
//        System.out.println(user.getDate());
        user.setIsDelete(u.getIsDelete());
        user.setIsLimit(u.getIsLimit());
        user.setFollowers(followers);
        user.setFans(fans);
        user.setNickname(u.getNickname());
        user.setPassword(u.getPassword());
        return user;
    }

    public Integer verifyUserLimit(String username, String email) throws Exception {
        Integer result=-1;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("username",username);
        map.put("email",email);
        result=(Integer)sqlMapClient.queryForObject("user_sqlMap.verify_user_limit",map);
        if(result!=null){
            return result;
        }else{
            return -1;
        }
    }

    public UserSnapshot getUserSnapshotById(int id) throws Exception {
        return (UserSnapshot) sqlMapClient.queryForObject("user_sqlMap.query_user_snapshot_by_id",id);
    }

    @Override
    public Integer getMediaIdByUserId(int id) throws Exception {
        return (Integer)sqlMapClient.queryForObject("user_sqlMap.get_media_id_by_user_id",id);
    }
}
