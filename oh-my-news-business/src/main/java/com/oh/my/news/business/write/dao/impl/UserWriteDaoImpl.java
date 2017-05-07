package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.UserWriteDao;
import com.oh.my.news.model.po.User;
import com.oh.my.news.model.po.UserWrite;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by llf on 2017/5/4.
 */
@Repository
public class UserWriteDaoImpl implements UserWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;
    public void insertUser(UserWrite user) throws Exception {
        sqlMapClient.insert("user_sqlMap.insert_user",user);
    }

    public void insertSignature(Integer userId, String signature) throws Exception {
        Map<String,Object> map=new HashedMap();
        map.put("userId",userId);
        map.put("signature",signature);
        sqlMapClient.update("user_sqlMap.insert_signature",map);
    }

    public void insertAnnouncement(Integer userId, String announcement) throws Exception {
        Map<String,Object> map=new HashedMap();
        map.put("userId",userId);
        map.put("announcement",announcement);
        sqlMapClient.update("user_sqlMap.insert_announcement",map);
    }

    public void updateUser(UserWrite user) throws Exception {
        sqlMapClient.update("user_sqlMap.update_user",user);
    }
}
