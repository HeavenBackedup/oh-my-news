package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.CommentReadDao;
import com.oh.my.news.model.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dzhaoooo on 17/5/5.
 */
@Repository
public class CommentReadDaoImpl implements CommentReadDao {

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public Comment queryCommentById(int id)throws Exception{
        return (Comment)sqlMapClient.queryForObject("comment_sqlMap.query_comment_by_id",id);
    }

    public List<Comment> queryCommentsByArticleId(int articleId, int currentPage, int pageItemNum)throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        map.put("articleId",articleId);
        return (List<Comment>)sqlMapClient.queryForList("comment_sqlMap.query_comments_by_article_id",map);
    }

    public List<Comment> queryRootCommentsByArticleId(int articleId, int currentPage, int pageItemNum) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageItemNum",pageItemNum);
        map.put("currentPage",(currentPage-1)*pageItemNum);
        map.put("articleId",articleId);
        return (List<Comment>)sqlMapClient.queryForList("comment_sqlMap.query_root_comment_by_article_id",map);
    }

    public List<Comment> queryCommentsByRootCommentId(int rootCommentId) throws Exception{
        return (List<Comment>)sqlMapClient.queryForList("comment_sqlMap.query_comments_by_root_comment_id",rootCommentId);
    }


    //返回结果为该新闻的评论所占的页数
    public Integer queryPageNum(int articleId, int pageItemNum) throws Exception {
        if(pageItemNum==0)
            throw new Exception("pageItemNum cannot be 0");
        int comment_num= (Integer) sqlMapClient.queryForObject("comment_sqlMap.query_page_num",articleId);
        return comment_num%pageItemNum==0?comment_num/pageItemNum:comment_num/pageItemNum+1;
    }


    public Integer queryRootCommentIdByFormerCommentId(int formerCommentId) throws Exception{
        return (Integer)sqlMapClient.queryForObject("comment_sqlMap.query_root_comment_id_by_former_comment_id",formerCommentId);
    }

    public Integer queryArticleIdByFormerCommentId(int formerCommentId) throws Exception {
        return (Integer)sqlMapClient.queryForObject("comment_sqlMap.query_article_id_by_former_comment_id",formerCommentId);
    }

    @Override
    public Integer queryCountByArticleId(int articleId) throws Exception {
        return (Integer)sqlMapClient.queryForObject("comment_sqlMap.query_count_by_article_id",articleId);
    }
}
