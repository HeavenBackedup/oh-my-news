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
        Map<String,Object> map=new HashedMap();
        map.put("username",username);
        map.put("password",password);
        return (Integer) sqlMapClient.queryForObject("uer_sqlMap.username_query_user",map);
    }

    public Integer queryUserbyemail(String email,String password) throws Exception {
        Map<String,Object> map=new HashedMap();
        map.put("email",email);
        map.put("password",password);
        return (Integer) sqlMapClient.queryForObject("uer_sqlMap.email_query_user",map);
    }

    public UserDto queryUserDetail(int userId) throws Exception {
        User u=(User)sqlMapClient.queryForObject("query_user_detail",userId);
        int followers=(Integer) sqlMapClient.queryForObject("calculate_followers",userId);
        int fans=(Integer) sqlMapClient.queryForObject("calculate_fans",userId);
        UserDto user=new UserDto();
        user.setId(u.getId());
        user.setUsername(u.getUsername());
        user.setEmail(u.getEmail());
        user.setAddress(u.getAddress());
        user.setAnnouncement(u.getAnnouncement());
        user.setImageUrl(u.getImageUrl());
        user.setDate(user.getDate());
        user.setIsDelete(u.getIsDelete());
        user.setIsLimit(u.getIsLimit());
        user.setFollowers(followers);
        user.setFans(fans);
        user.setNickname(u.getNickname());
        user.setPassword(u.getPassword());
        return user;
    }


    public UserSnapshot getUserSnapshotById(int id) throws Exception {
        return (UserSnapshot)sqlMapClient.queryForObject("user_sqlMap.query_user_snapshot_by_id",id);
    }

    public User getUserById(int id) throws Exception {
        return null;
    }
}
