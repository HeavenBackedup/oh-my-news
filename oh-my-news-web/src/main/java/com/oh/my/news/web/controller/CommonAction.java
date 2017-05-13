package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.CategoryReadManage;
import com.oh.my.news.model.vo.edit.Category;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/4/15.
 */
@Controller
@RequestMapping(value = "/common")
public class CommonAction extends BaseAction{

   @Resource
   private CategoryReadManage categoryReadManage;



   private static Logger logger = Logger.getLogger(CommonAction.class);
    @RequestMapping(value = "/getCategories")
    public @ResponseBody
    Object getCategoties()throws Exception{
        try {
            List<com.oh.my.news.model.po.Category>categories=new ArrayList<com.oh.my.news.model.po.Category>();
            categories=categoryReadManage.getCategories();
            return successReturnObject(categories);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }





    }
}
