package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.UserWriteDao;
import com.oh.my.news.model.po.User;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * Created by llf on 2017/5/4.
 */
public class UserWriteDaoImpl implements UserWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;
    public void insertUser(User user) throws Exception {
        sqlMapClient.insert("user_sqlMap.insert_user",user);
    }

    public void insertSignature(String userId, String signature) throws Exception {
        Map<String,Object> map=new HashedMap();
        map.put("userId",userId);
        map.put("signature",signature);
        sqlMapClient.update("insert_signature",map);
    }

    public void insertAnnouncement(String userId, String announcement) throws Exception {
        Map<String,Object> map=new HashedMap();
        map.put("userId",userId);
        map.put("announcement",announcement);
        sqlMapClient.update("insert_announcement",map);
    }

    public void updateUser(User user) throws Exception {
        sqlMapClient.update("update_user",user);
    }
}
