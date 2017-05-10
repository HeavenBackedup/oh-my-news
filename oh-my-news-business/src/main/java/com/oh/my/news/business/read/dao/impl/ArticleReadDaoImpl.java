package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.ArticleReadDao;
import com.oh.my.news.business.read.dao.TransactionReadDao;
import com.oh.my.news.model.po.ArticleReader;
import com.oh.my.news.model.po.ArticleReaderType;
import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by shj on 2017/5/9.
 */
@Repository
public class ArticleReadDaoImpl implements ArticleReadDao {

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    @Autowired
    private TransactionReadDao transactionReadDao;


    public Integer queryUserIdById(int id) throws Exception {
        return (Integer) sqlMapClient.queryForObject("article_sqlMap.query_user_id_by_id",id);
    }


    public Article getArticleById(int id)throws Exception {
        return (Article) sqlMapClient.queryForObject("article_sqlMap.query_article",id);
    }

    public ArticleReader getArticleReaderById(Integer articleId, Integer userId)throws Exception {
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("articleId",articleId);
        map.put("userId",userId);
        List<ArticleReaderType> articleReaderType = (List<ArticleReaderType>)sqlMapClient.queryForList("article_sqlMap.query_articleReaderType",map);
        ArticleReader articleReader = new ArticleReader();
        articleReader.setarticleId(articleId);
        articleReader.setUserId(userId);
        articleReader.setScore(3);
        articleReader.setDonation(0);
        articleReader.setcollected(false);
        articleReader.setReport(false);
        articleReader.setThumbUp(false);
        for (ArticleReaderType aRT: articleReaderType){
            if (aRT.getType()==2){
                articleReader.setScore((int)aRT.getValue());
            }else if(aRT.getType()==3){
                articleReader.setReport(true);
            }
//            else if(aRT.getType()==4){
//                articleReader.setDonation(aRT.getValue());
//            }
            else if(aRT.getType()==5){
                articleReader.setThumbUp(true);
            }else if(aRT.getType()==6){
                articleReader.setcollected(true);
            }
        }
        List<Transaction> transactions = transactionReadDao.donated(userId);
        float donation = 0;
        for (Transaction transaction:transactions){
            if (articleId == transaction.getArticleId()){
                donation += transaction.getAmount();
            }
        }
        articleReader.setDonation(donation);

        return articleReader;
    }

    public List<Article> getHistoryArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        return (List<Article>) sqlMapClient.queryForList("article_sqlMap.query_history_article",map);
    }

    public Integer getHistoryArticlesCountByUserId(int userId)throws Exception {
        return (Integer) sqlMapClient.queryForObject("article_sqlMap.query_history_article_count",userId);
    }

    public List<Article> getDraftArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        return (List<Article>) sqlMapClient.queryForList("article_sqlMap.query_draft_article",map);
    }

    public Integer getDraftArticlesCountByUserId(int userId)throws Exception {
        return (Integer) sqlMapClient.queryForObject("article_sqlMap.query_draft_article_count",userId);
    }

    public List<Article> getCollectedArticlesByUserId(int userId, int currentPage, int pageItemNum)throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("userId",erId);
        map.put("userId",userId);
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
//        System.out.println(map);
//        System.out.println("smysmy...."+(List<Article>) sqlMapClient.queryForList("article_sqlMap.query_collected_article",map));
        return (List<Article>) sqlMapClient.queryForList("article_sqlMap.query_collected_article",map);
    }

    public Integer getCollectedArticlesCountByUserId(int userId)throws Exception {
        return (Integer) sqlMapClient.queryForObject("article_sqlMap.query_collected_article_count",userId);
    }


    @Override
    public List<Article> getCollectedArticlesByUserId(int userId, int currentPage, int pageItemNum, int sortType) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("userId",erId);
        map.put("userId",userId);
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        map.put("sortType",sortType);
        return (List<Article>) sqlMapClient.queryForList("article_sqlMap.query_collected_article_sort",map);
    }

    @Override
    public List<Article> getHistoryArticlesByUserId(int userId, int currentPage, int pageItemNum, int sortType) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        map.put("sortType",sortType);
        return (List<Article>) sqlMapClient.queryForList("article_sqlMap.query_history_article_sort",map);
    }
}

