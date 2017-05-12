package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.dto.CommentPageDto;
import com.oh.my.news.model.po.Comment;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public interface CommentReadDao {

    /**
     *
     * @param id
     * @return 通过评论的id返回该评论的具体信息
     * @throws Exception
     */
    Comment queryCommentById(int id)throws Exception;

    /**
     *
     * @param articleId 文章id
     * @param currentPage 当前页数
     * @param pageItemNum 一页可容纳的评论个数
     * @return 返回该文章对应的评论列表
     * @throws Exception
     */
    List<Comment> queryCommentsByArticleId(int articleId, int currentPage, int pageItemNum)throws Exception;

    /**
     *
     * @param articleId  文章id
     * @param currentPage  当前页数
     * @param pageItemNum  一页可容纳的评论个数
     * @return 返回该文章下该页对应的所有根评论
     * @throws Exception
     */

    List<Comment> queryRootCommentsByArticleId(int articleId,int currentPage,int pageItemNum)throws Exception;

    /**
     *
     * @param rootCommentId 根评论id
     * @return 根据根评论id返回该根评论及其对应的子评论
     * @throws Exception
     */
    List<Comment> queryCommentsByRootCommentId(int rootCommentId) throws Exception;

    /**
     *
     * @param pageItemNum  一页可容纳的评论个数
     * @return  根据评论总数计算出评论的总页数
     * @throws Exception
     */
    Integer queryPageNum(int articleId, int pageItemNum)throws Exception;

    /**
     *
     * @param formerCommentId
     * @return 返回formerCommentId对应的根评论id
     * @throws Exception
     */
    Integer queryRootCommentIdByFormerCommentId(int formerCommentId) throws Exception;

    /**
     *
     * @param formerCommentId
     * @return 返回formerCommentId对应的文章id
     * @throws Exception
     */

    Integer queryArticleIdByFormerCommentId(int formerCommentId) throws Exception;


    Integer queryCountByArticleId(int articleId)throws Exception;

}
