package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.ArticleRecommendDao;
import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.vo.mainpage.EditContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
@Repository
public class ArticleRecommendDaoImpl implements ArticleRecommendDao {



    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public List<ArticleSnapshot> queryCollectList() throws Exception {
        return (List<ArticleSnapshot>)sqlMapClient.queryForList("article_sqlMap.query_collect_list");
    }

    public List<ArticleSnapshot> queryMarkList() throws Exception {
        return (List<ArticleSnapshot>)sqlMapClient.queryForList("article_sqlMap.query_mark_list");
    }

    public List<ArticleSnapshot> queryLastList() throws Exception {
        return (List<ArticleSnapshot>)sqlMapClient.queryForList("article_sqlMap.query_last_list");

    }

    public List<EditContent> queryRecommendByCategoryId(int categoryId, int currentPage, int pageItemNum) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        //根据categoryId是否为1选择不同的查询策略（categoryId为1代表首页新闻）
        if(categoryId==1){
            return (List<EditContent>)sqlMapClient.queryForList("article_sqlMap.query_all",map);
        }else{
            map.put("categoryId",categoryId);
            return (List<EditContent>)sqlMapClient.queryForList("article_sqlMap.query_by_category_id",map);
        }
    }
}
