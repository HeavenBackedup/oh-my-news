package com.oh.my.news.web.controller;

import com.oh.my.news.model.vo.detail.*;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.web.controller.detailData.DetailData;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Prometheus on 2017/4/20.
 */
@Controller
@RequestMapping(value = "/detail")
public class DetailAction extends BaseAction {


    @RequestMapping(value = "/pageReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)//请求评论
    public @ResponseBody Object pageReq(@RequestBody Map pageMap) throws IOException {
        System.out.println("smy: "+pageMap);
        int currentPage = Integer.parseInt(pageMap.get("currentPage").toString().trim());
        Map<String,Object> map = new HashMap();

        List<RootComments> rootCommentsList = DetailData.getRootCommentsList(currentPage);

//        ObjectMapper mapper = new ObjectMapper();
//        String Json =  mapper.writeValueAsString(commentList);

        System.out.println("smy: "+rootCommentsList);

        map.put("pagination",new Pagination(200,currentPage));
        map.put("comments",rootCommentsList);
        return successReturnObject(map);
    }

    @RequestMapping(value = "/articleReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)//请求文章
    public @ResponseBody Object articleReq(@RequestBody Map articleMap) throws IOException {
        Map<String,Object> map = new HashMap();
        System.out.println("smy: "+ articleMap);
        int articleId = Integer.parseInt(articleMap.get("articleId").toString().trim());

        Article article = DetailData.getarticle(articleId);
        ArticleReader articleReader = DetailData.getarticleReader(articleId);

        System.out.println("smy: "+ article);
        map.put("article", article);
        map.put("articleReader", articleReader);

        return successReturnObject(map);
    }


    @RequestMapping(value = "/submit",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object submit(@RequestBody Map submitMap) throws IOException {
//        Map<String,Object> map = new HashMap();
        System.out.println(submitMap);

        return successReturnObject("submitsuccess");
    }

}
