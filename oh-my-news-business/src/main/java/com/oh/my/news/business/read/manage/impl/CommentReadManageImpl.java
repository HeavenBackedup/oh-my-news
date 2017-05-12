package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.CommentReadDao;
import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.business.read.manage.CommentReadManage;
import com.oh.my.news.model.dto.CommentDto;
import com.oh.my.news.model.dto.CommentPageDto;
import com.oh.my.news.model.dto.Pagination;
import com.oh.my.news.model.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/5.
 */
@Service
public class CommentReadManageImpl implements CommentReadManage {
    @Autowired
    private CommentReadDao commentReadDao;
    @Autowired
    private UserReadDao userReadDao;
    public CommentPageDto getComments(int articleId, int currentPage, int pageItemNum)throws Exception{
        CommentPageDto commentPageDto = new CommentPageDto();
        Pagination pagination = new Pagination();
        List<List<CommentDto>> commentDtoes = new ArrayList<List<CommentDto>>();
        //comments为所有根评论的list
        List<Comment> comments= commentReadDao.queryRootCommentsByArticleId(articleId,currentPage,pageItemNum);
        //totalItems为评论总页数
        pagination.setTotalItems(commentReadDao.queryPageNum(articleId,pageItemNum));
        pagination.setCurrentPage(currentPage);
        //对所有的根评论进行遍历
        for(Comment c:comments){
            //childrenComment为该根评论及其对应的子评论
            List<Comment> childrenComment = commentReadDao.queryCommentsByRootCommentId(c.getId());
            List<CommentDto> childrenCommentDtoes = new ArrayList<CommentDto>();
            //对每一条根评论及其对应的子评论进行遍历
            for(Comment co:childrenComment){
                CommentDto commentDto = new CommentDto();
                commentDto.setComment(co);
                commentDto.setReplier(userReadDao.getUserSnapshotById(co.getUserId()));
                if(co.getFormerCommentId()>0){
                    commentDto.setFormerReplier(userReadDao.getUserSnapshotById(co.getFormerCommentId()));
                }
                //遍历评论列表，找出所有评论的前一条评论
                for(Comment coFormer:childrenComment){
                    if(coFormer.getId()==co.getFormerCommentId()){
                        commentDto.setFormerComment(coFormer);
                        break;
                    }
                }
                childrenCommentDtoes.add(commentDto);
            }
            commentDtoes.add(childrenCommentDtoes);
        }
        commentPageDto.setComments(commentDtoes);
        commentPageDto.setPagination(pagination);
        return commentPageDto;
    }

}
