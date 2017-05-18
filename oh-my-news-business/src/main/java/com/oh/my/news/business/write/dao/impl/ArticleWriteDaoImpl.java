package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.ArticleWriteDao;
import com.oh.my.news.model.po.Article;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by shj on 2017/5/9.
 */
@Repository
public class ArticleWriteDaoImpl implements ArticleWriteDao {
    @Autowired
    @Qualifier("sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public void insertUARelReturnId(Integer userId, Integer articleId, Integer type, Float value) throws Exception {
        Map<String,Object> map = new HashedMap();
        map.put("userId",userId);
        map.put("articleId",articleId);
        map.put("type",type);
        map.put("value",value);
        sqlMapClient.insert("u_a_rel_sqlMap.insert_u_a_rel",map);

    }




    public Integer insertArticleReturnId(Article article) throws Exception {
        return (Integer) sqlMapClient.insert("article_sqlMap.insert_article", article);
    }


    public boolean ifOpDone(int userId, int articleId, int type) throws Exception {
        Map<String,Object> map = new HashedMap();
        map.put("userId",userId);
        map.put("articleId",articleId);
        map.put("type",type);

        Integer id =  (Integer) sqlMapClient.queryForObject("article_sqlMap.if_op_done",map);
        if(id ==null)
            return false;
        return true;
    }

    public void updateCollect(int id) throws Exception {
        sqlMapClient.update("article_sqlMap.update_collect",id);
    }


    public void updateMark(int id, float score) throws Exception {
        Map<String,Object> map = new HashedMap();
        map.put("id",id);
        map.put("score",score);
        sqlMapClient.update("article_sqlMap.update_mark",map);
    }


    public void updateReport(int id) throws Exception {
        sqlMapClient.update("article_sqlMap.update_report",id);
    }

    public void updateThumbUp(int id) throws Exception {
        sqlMapClient.update("article_sqlMap.update_thumb_up",id);
    }


    public void publishArticle(Article article) throws Exception {
        sqlMapClient.update("article_sqlMap.article_publish",article);
    }


    @Override
    public void updateDonate(int id, int donate) throws Exception {
        Map<String,Object>  map = new HashedMap();
        map.put("id",id);
        map.put("donate",donate);
        sqlMapClient.update("article_sqlMap.update_donate",map);
    }

    public void saveArticle(Article article) throws Exception {
        sqlMapClient.update("article_sqlMap.article_save",article);
    }


    public void saveMedia(List<Integer> mediaIds, int articleId) throws Exception {
        if(CollectionUtils.isEmpty(mediaIds))
            return;
        for(int mId:mediaIds){
            Map<String,Object> map  = new HashedMap();
            map.put("articleId",articleId);
            map.put("mediaId",mId);
            sqlMapClient.insert("a_m_rel_sqlMap.insert_a_m_rel",map);
        }



    }
}
