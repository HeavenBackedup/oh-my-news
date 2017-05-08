package com.oh.my.news.web.controller.mainpage;

import com.oh.my.news.business.read.manage.ArticleRecommendManage;
import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.mainpage.EditContent;
import com.oh.my.news.web.util.BaseAction;
import mainpage.News;
import org.springframework.stereotype.Controller;
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

    //新闻显示
    @RequestMapping(value = "/showPage", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object showPage(@RequestBody Map showPageMap) {
        System.out.println(showPageMap);
        int index = Integer.parseInt(showPageMap.get("pageIndex").toString().trim());
        int currentPage = Integer.parseInt(showPageMap.get("currentPage").toString().trim());
        int pageItemNum=6;

        List<EditContent> list=new ArrayList<EditContent>();
        try {
            list=articleRecommendManage.getRecommendByCategoryId(index,currentPage,pageItemNum);
            Map<String, Object> itemsmap = new HashMap<String, Object>();
            itemsmap.put("newList", list);
            itemsmap.put("pageIndex",index);
            itemsmap.put("pagination",new Pagination(200,currentPage));
            return successReturnObject(itemsmap);

        }catch (Exception e){
            e.printStackTrace();
            return failReturnObject("show page error");
        }

    }


    //收藏排行
    @RequestMapping(value = "/collectList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object collect(@RequestBody Map indexMap) {
        List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();
        try {
            lists=articleRecommendManage.getCollect();
            Map<String, Object> collectmap = new HashMap<String, Object>();
            collectmap.put("collectList", lists);
            return successReturnObject(collectmap);
        }catch (Exception e){
            e.printStackTrace();
            return failReturnObject("get collectList fail");
        }





    }
    //评论排行
    @RequestMapping(value = "/markList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
        Object mark(@RequestBody Map indexMap) {
        List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();
        try{
            lists=articleRecommendManage.getMark();
            Map<String, Object> markmap = new HashMap<String, Object>();
            markmap.put("markList", lists);
            return successReturnObject(markmap);

        }catch (Exception e){
            e.printStackTrace();
            return failReturnObject("get markList fail");
        }



    }
    //最新动态
    @RequestMapping(value = "/lastList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
    Object last(@RequestBody Map indexMap) {
        List<ArticleSnapshot> lists = new ArrayList<ArticleSnapshot>();
        try {
            lists=articleRecommendManage.getLast();
            Map<String, Object> lastmap = new HashMap<String, Object>();
            lastmap.put("lastList", lists);
            return successReturnObject(lastmap);

        }catch (Exception e){
            e.printStackTrace();
            return failReturnObject("get lastList fail");
        }


    }



}
