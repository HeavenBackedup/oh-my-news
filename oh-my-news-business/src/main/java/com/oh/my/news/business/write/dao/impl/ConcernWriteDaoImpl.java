package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.ConcernWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
@Repository
public class ConcernWriteDaoImpl implements ConcernWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public void deleteConcernByIds(Integer userId, Integer followerId) throws Exception {
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("userId",userId);
        map.put("followerId",followerId);
        sqlMapClient.update("concern_sqlMap.delete_concern_rel_by_ids",map);
    }

    public void insertConcernByIds(Integer userId, Integer followerId) throws Exception {
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("userId",userId);
        map.put("followerId",followerId);
        sqlMapClient.insert("concern_sqlMap.insert_concern_rel_by_ids",map);
    }
}
