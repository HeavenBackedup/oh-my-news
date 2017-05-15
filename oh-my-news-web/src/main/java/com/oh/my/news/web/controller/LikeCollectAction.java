package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.model.dto.ArticleCategoryDto;
import com.oh.my.news.model.dto.ArticleDto;
import com.oh.my.news.model.dto.Image;
import com.oh.my.news.model.dto.SortType;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.Content;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leilei on 2017/4/20.
 */
@Controller
@RequestMapping(value = "/like_collect")
public class LikeCollectAction extends BaseAction {
    @Resource
    private ArticleReadManage articleReadManage;

    private Logger logger = Logger.getLogger(LikeCollectAction.class);
    @RequestMapping(value = "/getInit", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getInit(@RequestBody Map initMap) throws Exception{
        try {
            List<Content> contents = new ArrayList<Content>();
            int userId=Integer.parseInt(initMap.get("id").toString().trim());
            int pageItemNum=3;
            ArticleDto historyLists=articleReadManage.getCollectedArticles(userId,1,pageItemNum, SortType.DATE);
            List<ArticleCategoryDto> list=historyLists.getArticle();
            for(ArticleCategoryDto article:list){
                Content content=new Content();
                content.setTopic(article.getArticle().getTopic());
                content.setArticle(article.getArticle().getContentSnapshot());
                content.setAuthor(article.getUserSnapshot().getNickname());
                content.setId(article.getArticle().getId());
                contents.add(content);
            }
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("pagination",historyLists.getPagination());
            map.put("contents",contents);
            return successReturnObject(map);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }

    //安卓端获取数据
    @RequestMapping(value = "/getContents",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public
    @ResponseBody
    Object getContents(@RequestBody Map indexMap)throws Exception{
        try {
            int userId=Integer.parseInt(indexMap.get("userId").toString().trim());
            int pageItemNum=100;
            ArticleDto collectLists=articleReadManage.getCollectedArticles(userId,1,pageItemNum,SortType.DATE);
            List<ArticleCategoryDto> list=collectLists.getArticle();
            List<Object> contents=new ArrayList<Object>();
            Map<String,Object> collectMap=new HashMap<String, Object>();
            for (ArticleCategoryDto articleCategoryDto:list){
                Map<String,Object> map=new HashMap<String, Object>();
                map.put("articleId",articleCategoryDto.getArticle().getId());
                List<Image> images=articleCategoryDto.getImages();
                if(!CollectionUtils.isEmpty(images)){
                    map.put("articlePic",images.get(0).getUrl());
                }else {
                    map.put("articlePic",null);
                }
                map.put("authorId",articleCategoryDto.getUserSnapshot().getId());
                map.put("nickname",articleCategoryDto.getUserSnapshot().getNickname());
                map.put("avatar",articleCategoryDto.getUserSnapshot().getImageUrl());
                map.put("articleContent",articleCategoryDto.getArticle().getContentSnapshot());
                map.put("collectedNum",articleCategoryDto.getArticle().getCollected());
                map.put("topic",articleCategoryDto.getArticle().getTopic());
                contents.add(map);
            }
            collectMap.put("data",contents);
            return successReturnObject(collectMap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }



    }

    @RequestMapping(value = "/getContent", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getContent(@RequestBody Map ctgyMap) throws Exception{
        try {
            List<Content> contents = new ArrayList<Content>();
            int userId=Integer.parseInt(ctgyMap.get("id").toString().trim());
            int currentPage = Integer.parseInt(ctgyMap.get("currentPage").toString().trim());
            int value=Integer.parseInt(ctgyMap.get("value").toString().trim());
            int pageItemNum=3;
            SortType sortType=SortType.DATE;
            switch (value){
                case 1:
                    sortType = SortType.DATE;
                    break;
                case 2:
                    sortType=SortType.THUMUP;
                    break;
                case 3:
                    sortType=SortType.DONATE;
                    break;
            }
            ArticleDto collectLists=articleReadManage.getCollectedArticles(userId,currentPage,pageItemNum,sortType);
            List<ArticleCategoryDto> list=collectLists.getArticle();
            for(ArticleCategoryDto article:list){
                Content content=new Content();
                content.setTopic(article.getArticle().getTopic());
                content.setArticle(article.getArticle().getContentSnapshot());
                content.setAuthor(article.getUserSnapshot().getNickname());
                content.setId(article.getArticle().getId());
                contents.add(content);
            }
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("pagination",collectLists.getPagination());
            map.put("contents",contents);
            return successReturnObject(map);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }
}



