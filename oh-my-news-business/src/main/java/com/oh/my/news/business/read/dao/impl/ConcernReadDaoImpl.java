package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.ConcernReadDao;
import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.po.Concern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dzhaoooo on 17/5/3.
 */
@Repository
public class ConcernReadDaoImpl implements ConcernReadDao{
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;
    public List<UserSnapshot> queryMyConcernsById(Integer id) throws Exception{
       return (List<UserSnapshot>)sqlMapClient.queryForList("concern_sqlMap.query_concerns_by_id",id);
    }
    public List<UserSnapshot> queryMyFansById(Integer id) throws Exception{
      return (List<UserSnapshot>)sqlMapClient.queryForList("concern_sqlMap.query_fans_by_id",id);
    }
    public boolean  checkConcernRelById(int userId,int followerId) throws Exception{
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("userId",userId);
        map.put("followerId",followerId);
        int num=(Integer)sqlMapClient.queryForObject("concern_sqlMap.check_concern_rel_by_ids",map);
        return num==0?false:true;


    }
}
