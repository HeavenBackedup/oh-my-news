package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.model.dto.ArticleCategoryDto;
import com.oh.my.news.model.dto.ArticleDto;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.Content;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leilei on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/draft")
public class DraftAction extends BaseAction {

    @Resource
    private ArticleReadManage articleReadManage;

    @RequestMapping(value = "/getInit", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getInit(@RequestBody Map initMap) throws Exception{
        List<Content> contents = new ArrayList<Content>();
        int userId=Integer.parseInt(initMap.get("id").toString().trim());
        int pageItemNum=3;
        System.out.println(userId);
            ArticleDto draftLists=articleReadManage.getDraftArticles(userId,1,pageItemNum);
            List<ArticleCategoryDto> list=draftLists.getArticle();
            for(ArticleCategoryDto article:list){
                Content content=new Content();
                content.setTopic(article.getArticle().getTopic());
                content.setArticle(article.getArticle().getContentSnapshot());
                content.setAuthor(article.getUserSnapshot().getNickname());
                content.setId(article.getArticle().getId());
                contents.add(content);
            }
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("pagination",draftLists.getPagination());
            map.put("contents",contents);
            return successReturnObject(map);

    }


    @RequestMapping(value = "/getContent", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getContent(@RequestBody Map ctgyMap) throws Exception{
//         int MAX_SIZE = 200;
        List<Content> contents = new ArrayList<Content>();
        int userId=Integer.parseInt(ctgyMap.get("id").toString().trim());
        int currentPage = Integer.parseInt(ctgyMap.get("currentPage").toString().trim());
        int pageItemNum=3;
            ArticleDto draftLists=articleReadManage.getDraftArticles(userId,currentPage,pageItemNum);
            System.out.println(draftLists);
            List<ArticleCategoryDto> list=draftLists.getArticle();
            for(ArticleCategoryDto article:list){
                Content content=new Content();
                content.setTopic(article.getArticle().getTopic());
                content.setArticle(article.getArticle().getContentSnapshot());
                content.setAuthor(article.getUserSnapshot().getNickname());
                content.setId(article.getArticle().getId());
                contents.add(content);
            }
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("pagination",draftLists.getPagination());
            map.put("contents",contents);
            return successReturnObject(map);

    }
}

