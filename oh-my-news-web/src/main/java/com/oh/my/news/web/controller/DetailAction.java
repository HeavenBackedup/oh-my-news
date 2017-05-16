package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.business.read.manage.CommentReadManage;
import com.oh.my.news.business.write.manage.ArticleWriteManage;
import com.oh.my.news.business.write.manage.CommentWriteManage;
import com.oh.my.news.model.dto.ArticleDetail;
import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.dto.CommentDto;
import com.oh.my.news.model.dto.CommentPageDto;
import com.oh.my.news.model.po.*;
import com.oh.my.news.model.vo.detail.*;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.detail.Article;
import com.oh.my.news.model.vo.detail.ArticleReader;
import com.oh.my.news.model.vo.detail.Comment;
import com.oh.my.news.model.vo.detail.User;
import com.oh.my.news.model.vo.edit.*;
import com.oh.my.news.model.vo.edit.Category;
import com.oh.my.news.web.controller.detailData.DetailData;
import com.oh.my.news.web.util.BaseAction;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

/**
 * Created by Prometheus on 2017/4/20.
 */
@Controller
@RequestMapping(value = "/detail")
public class DetailAction extends BaseAction {


    @Autowired
    private CommentReadManage commentReadManage;

    @Autowired
    private ArticleReadManage articleReadManage;
    @Autowired
    private ArticleWriteManage articleWriteManage;
    @Autowired
    private CommentWriteManage commentWriteManage;

    private static Logger logger = Logger.getLogger(DetailAction.class);
    @RequestMapping(value = "/pageReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)//请求评论
    public @ResponseBody Object pageReq(@RequestBody Map pageMap) throws IOException,Exception{

        try {
            int currentPage = Integer.parseInt(pageMap.get("currentPage").toString().trim());
            int articleId  = (Integer) pageMap.get("articleId");
            Map<String,Object> map = new HashMap();
            CommentPageDto commentPageDto = commentReadManage.getComments(articleId,currentPage,5);

            List<RootComments> rootCommentss = new ArrayList<RootComments>();
            for(List<CommentDto> l:commentPageDto.getComments()){
                if(CollectionUtils.isEmpty(l))
                    continue;
                RootComments rootComments = new RootComments();
                rootComments.setUnfold(false);
                for(CommentDto c:l){
                    Comment comment = new Comment();
                    comment.setId(c.getComment().getId());
                    comment.setContent(c.getComment().getContent());
                    comment.setarticleId(c.getComment().getArticleId());
                    comment.setDate(c.getComment().getDate().toString());
                    User user = new User();
                    user.setName(c.getReplier().getNickname());
                    user.setUserId(c.getReplier().getId());
                    user.setUserImgSrc(c.getReplier().getImageUrl());
                    user.setTotalMoney(1000.0f);
                    comment.setReplier(user);
                    if(c.getFormerComment()==null){
                        rootComments.getComments().add(comment);
                        continue;
                    }

                    if(c.getFormerReplier()==null) {
                        rootComments.getComments().add(comment);
                        continue;
                    }
                    User fomerUser = new User();
                    Comment formerComment =  new Comment();
                    fomerUser.setTotalMoney(1000.f);
                    fomerUser.setUserImgSrc(c.getFormerReplier().getImageUrl());
                    fomerUser.setUserId(c.getFormerReplier().getId());
                    fomerUser.setTotalMoney(1000.0f);
                    fomerUser.setName(c.getFormerReplier().getNickname());
                    formerComment.setReplier(fomerUser);
                    formerComment.setDate(c.getFormerComment().getDate().toString());
                    formerComment.setarticleId(c.getFormerComment().getArticleId());
                    formerComment.setContent(c.getFormerComment().getContent());
                    formerComment.setId(c.getFormerComment().getId());
                    comment.setFormerComment(formerComment);
                    rootComments.getComments().add(comment);
                }
                rootCommentss.add(rootComments);
            }

            map.put("comments",rootCommentss);
            map.put("pagination",commentPageDto.getPagination());
            return successReturnObject(map);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    @RequestMapping(value = "/articleReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)//请求文章
    public @ResponseBody Object articleReq(@RequestBody Map articleMap) throws IOException,Exception {
        try {
            Map<String,Object> map = new HashMap();
            int articleId = Integer.parseInt(articleMap.get("articleId").toString().trim());
            Integer userId =(Integer) articleMap.get("userId");
            ArticleDetail articleDetail = articleReadManage.getArticleDetail(articleId,userId);
            Article article = new Article();
            ArticleInfo articleInfo = new ArticleInfo();
            article.setId(articleDetail.getArticleCategoryDto().getArticle().getId());
            articleInfo.setId(articleDetail.getArticleCategoryDto().getArticle().getId());
            articleInfo.setarticleScore(articleDetail.getArticleCategoryDto().getArticle().getScore());
            List<Article> authorPost = new ArrayList<Article>();
            List<ArticleSnapshot> authorPostSnapshot = articleReadManage.getAuthorPost(articleDetail.getArticleCategoryDto().getArticle().getUserId());
            for(ArticleSnapshot a:authorPostSnapshot){
                Article authorPostArticle = new Article();
                ArticleInfo articleInfoAuthor = new ArticleInfo();
                articleInfoAuthor.setId(a.getId());
                articleInfoAuthor.setTopic(a.getTopic());

                authorPostArticle.setArticleInfo(articleInfoAuthor);
                authorPost.add(authorPostArticle);
            }
            List<Article> relatedPost = new ArrayList<Article>();
            List<ArticleSnapshot> relatePost = articleReadManage.getRelatePost(articleDetail.getArticleCategoryDto().getArticle().getLabels());
            for(ArticleSnapshot a:relatePost){
                Article authorPostArticle = new Article();
                ArticleInfo articleInfoAuthor = new ArticleInfo();
                articleInfoAuthor.setId(a.getId());
                articleInfoAuthor.setTopic(a.getTopic());
                authorPostArticle.setArticleInfo(articleInfoAuthor);
                relatedPost.add(authorPostArticle);
            }

            articleInfo.setAuthorPost(authorPost);
            articleInfo.setRelatedPost(relatedPost);
            articleInfo.setarticleTime(articleDetail.getArticleCategoryDto().getArticle().getDate().toString());
            articleInfo.setHtmlContent(articleDetail.getArticleCategoryDto().getArticle().getContent());
            articleInfo.setCommentNum(articleDetail.getCommentNum());
            articleInfo.setLabels(Arrays.asList(new String[]{articleDetail.getArticleCategoryDto().getArticle().getLabels()}));
            articleInfo.setThumbupNum(articleDetail.getArticleCategoryDto().getArticle().getThumbUp());
            articleInfo.setReaded(1000);
            articleInfo.setTopic(articleDetail.getArticleCategoryDto().getArticle().getTopic());
            article.setArticleInfo(articleInfo);
            com.oh.my.news.model.vo.edit.Category category = new Category();
            category.setCatName(articleDetail.getArticleCategoryDto().getCategory().getName());
            category.setId(articleDetail.getArticleCategoryDto().getCategory().getId());
            article.setCategory(category);
            map.put("article", article);

            User user = new User();
            user.setName(articleDetail.getArticleCategoryDto().getUserSnapshot().getNickname());
            user.setTotalMoney(articleDetail.getTotalMoney());
            user.setUserId(articleDetail.getArticleCategoryDto().getUserSnapshot().getId());
            user.setUserImgSrc(articleDetail.getArticleCategoryDto().getUserSnapshot().getImageUrl());
            article.setUser(user);
            if(userId==null||userId==-1||userId==0){
                map.put("articleReader",null);
                return successReturnObject(map);
            }
            ArticleReader reader = new ArticleReader();
            reader.setcollected(articleDetail.isCollected());
            reader.setDonation(articleDetail.getDonation());
            reader.setReport(articleDetail.isReport());
            reader.setScore(articleDetail.getScore());
            reader.setReport(articleDetail.isReport());
            reader.setThumbUp(articleDetail.isThumbUp());
            reader.setReader(user);
            map.put("articleReader",reader);
//        map.put("articleReader", articleReader);
            return successReturnObject(map);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    @RequestMapping(value = "/submit",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object submit(@RequestBody Map submitMap) throws IOException,Exception {

        try {
            //        Map<String,Object> map = new HashMap();
            Map<String,Object> submitInfoMap = (Map<String, Object>) submitMap.get("submitInfo");

            Integer userId = (Integer) submitInfoMap.get("userId");
            Integer articleId = (Integer) submitInfoMap.get("articleId");
//        Integer
            Integer type = (Integer)submitMap.get("type");
            if(userId==null||userId==-1)
                throw new Exception("userid is null");
            if(articleId==null||articleId==-1)
                throw new Exception("articleId is null");
            if(type==null||type<1)
                throw new Exception("type is incorrect or is null");
            switch (type){
                case 1:
                    Map<String,Object> commentMap = (Map<String, Object>) submitInfoMap.get("comment");
                    String content = "";
                    if(commentMap.get("content")!=null)
                        content = commentMap.get("content").toString();
                    Integer formerCommentId = (Integer) commentMap.get("formerCommentId");
                    if(formerCommentId ==null)
                        formerCommentId = 0;
                    commentWriteManage.writeComment(userId,formerCommentId,articleId,content);
                    return successReturnObject(true);
                case 2:
                    Float score = Float.parseFloat(submitInfoMap.get("score").toString());
                    articleWriteManage.mark(userId,articleId,score);
                    return successReturnObject(true);
                case 3:
                    articleWriteManage.report(userId,articleId);
                    return successReturnObject(true);
                case 4:
                    Map<String,Object> rewardMap = (Map<String, Object>) ((Map<String, Object>) submitInfoMap.get("donation"));
                    String message = "";
                    if(!StringUtils.isEmpty(rewardMap.get("rewardmessage").toString()))
                        message = rewardMap.get("rewardmessage").toString();
                    Integer num = Integer.parseInt(rewardMap.get("num").toString());
                    return successReturnObject(articleWriteManage.donate(userId,articleId,num,message));
                case 5:
                    articleWriteManage.thumUp(userId,articleId);
                    return successReturnObject(true);
                case 6:
                    articleWriteManage.collect(userId,articleId);
                    return successReturnObject(true);

            }
            return successReturnObject(true);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    @RequestMapping(value = "/androidSubmit",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object androidSubmit(@RequestBody Map submitMap) throws IOException,Exception {
        try {
            Integer userId = Integer.parseInt(submitMap.get("userId").toString().trim());
            Integer articleId = Integer.parseInt(submitMap.get("articleId").toString().trim());
            String type=submitMap.get("type").toString().trim();
            if(userId<=0)
                throw new Exception("userid is null");
            if(articleId<=0)
                throw new Exception("articleId is null");
            String msg = "";
            switch(AndroidSubmitType.getValue(type)){
                //提交评论
                case 1:
                    //评论的内容,String类型
                    msg=submitMap.get("comment").toString();
                    if(StringUtils.isEmpty(msg))
                        throw new Exception("comment is null");
                    if(submitMap.get("formerCommentId")==null){
                        commentWriteManage.writeComment(userId,0,articleId,msg);
                        //将结果存入数据库
                        return successReturnObject(true);
                    }
                    Integer formerCommentId = Integer.parseInt(submitMap.get("formerCommentId").toString());
                    if(formerCommentId<0){
                        commentWriteManage.writeComment(userId,0,articleId,msg);
                        //将结果存入数据库
                        return successReturnObject(true);
                    }
                    commentWriteManage.writeComment(userId,formerCommentId,articleId,msg);
                    //将结果存入数据库
                    return successReturnObject(true);
                //提交打分
                case 2:
                    //分数
                    msg=submitMap.get("score").toString();
                    Float score = Float.parseFloat(msg);
                    articleWriteManage.mark(userId,articleId,score);
                    return successReturnObject(true);
                //将结果存入数据库
                //提交是否举报
                case 3:
                    articleWriteManage.report(userId,articleId);
                    return successReturnObject(true);
                //提交打赏
                case 4:
                    //打赏的金额
                    msg=submitMap.get("reward").toString();
                    Integer num = Integer.parseInt(msg);
                    //将结果存入数据库
                    return successReturnObject(articleWriteManage.donate(userId,articleId,num,"打赏"));
                //提交点赞
                case 5:
                    articleWriteManage.thumUp(userId,articleId);
                    return successReturnObject(true);
                //提交收藏
                case 6:
                    articleWriteManage.collect(userId,articleId);
                    return successReturnObject(true);
            }

            //返回值：成功存入数据库返回true,否则返回false
            return successReturnObject(false);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }


}
