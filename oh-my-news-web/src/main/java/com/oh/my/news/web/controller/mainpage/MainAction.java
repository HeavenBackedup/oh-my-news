package com.oh.my.news.web.controller.mainpage;

import com.oh.my.news.business.read.manage.ArticleRecommendManage;
import com.oh.my.news.business.read.manage.ImageReadManage;
import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.dto.EditContentDto;
import com.oh.my.news.model.po.File;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.mainpage.EditContent;
import com.oh.my.news.web.util.BaseAction;
import mainpage.News;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Dzhaoooo on 17/4/13.
 */
@Controller
@RequestMapping(value = "/mainpage")
public class MainAction extends BaseAction {


    @Resource
    private ArticleRecommendManage articleRecommendManage;

    @Resource
    private ImageReadManage imageReadManage;

    private static Logger logger = Logger.getLogger(MainAction.class);
    //新闻显示
    @RequestMapping(value = "/showPage", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object showPage(@RequestBody Map showPageMap) throws Exception {
//        System.out.println(showPageMap);
        try {
            int index = Integer.parseInt(showPageMap.get("pageIndex").toString().trim());
            int currentPage = Integer.parseInt(showPageMap.get("currentPage").toString().trim());
            int pageItemNum=4;

            EditContentDto editContentDto=new EditContentDto();

            editContentDto=articleRecommendManage.getRecommendByCategoryId(index,currentPage,pageItemNum);
            Map<String, Object> itemsmap = new HashMap<String, Object>();
            itemsmap.put("newList", editContentDto.getContents());
            itemsmap.put("pageIndex",index);
            itemsmap.put("pagination",editContentDto.getPagination());
            return successReturnObject(itemsmap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }



    }

    //安卓界面显示
    @RequestMapping(value = "/androidShowPage",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody
    Object mainPage(@RequestBody Map pageMap )throws Exception{
        try {
            int index=Integer.parseInt(pageMap.get("index").toString().trim());
            int addValue=Integer.parseInt(pageMap.get("addValue").toString().trim());
            int pageItemNum=6;
            EditContentDto editContentDto=articleRecommendManage.getRecommendByCategoryId(index,addValue,pageItemNum);
            List<EditContent> editContents=editContentDto.getContents();
            Map<String,Object> resultMap=new HashMap<String, Object>();
            List<Object> list=new ArrayList<Object>();

            for(EditContent editContent:editContents){
                Map<String,Object>map=new HashMap<String, Object>();
                int articleId=editContent.getId();
                List<File> imageUrls=imageReadManage.getImagesByArticleId(articleId);
                map.put("id",articleId);
                map.put("author",editContent.getAuthor());
                map.put("topic",editContent.getTopic());
                if(!CollectionUtils.isEmpty(imageUrls))
                {
                    map.put("url",imageUrls.get(0).getUrl());
                }else {
                    map.put("url",null);
                }
                list.add(map);
            }
            resultMap.put("newList",list);
            return successReturnObject(resultMap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }




    }


    //收藏排行
    @RequestMapping(value = "/collectList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object collect(@RequestBody Map indexMap) throws Exception{
        try {
            List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();

            lists=articleRecommendManage.getCollect();
            Map<String, Object> collectmap = new HashMap<String, Object>();
            collectmap.put("collectList", lists);
            return successReturnObject(collectmap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }


    }
    //评论排行
    @RequestMapping(value = "/markList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object mark(@RequestBody Map indexMap) throws Exception{
        try {
            List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();
            lists=articleRecommendManage.getMark();
            Map<String, Object> markmap = new HashMap<String, Object>();
            markmap.put("markList", lists);
            return successReturnObject(markmap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }


    //最新动态
    @RequestMapping(value = "/lastList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
    Object last(@RequestBody Map indexMap) throws Exception{
        try {
            List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();
            lists=articleRecommendManage.getLast();
            Map<String, Object> lastmap = new HashMap<String, Object>();
            lastmap.put("lastList", lists);
            return successReturnObject(lastmap);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }


    }






}
