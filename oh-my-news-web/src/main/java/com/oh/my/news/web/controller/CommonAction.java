package com.oh.my.news.web.controller;

import com.oh.my.news.model.vo.Category;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shj on 2017/4/15.
 */
@Controller
@RequestMapping(value = "/common")
public class CommonAction extends BaseAction{

    @RequestMapping(value = "/getCategories")
    public @ResponseBody Object getCategoties(){
        List<Category> categories = new ArrayList<Category>();
        Category category = new Category(1,null,"首页");
        Category category1 = new Category(2,null,"文化");
        Category category2 = new Category(3,null,"时尚");
        Category category3 = new Category(4,null,"娱乐");
        Category category4 = new Category(5,null,"房产");
        Category category5 = new Category(6,null,"科技");
        Category category6 =new Category(7,null,"汽车");
        Category category7 = new Category(8,null,"游戏");
        Category category8 = new Category(9,null,"体育");
        Category category9 = new Category(10,null,"书城");
        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);
        categories.add(category8);
        categories.add(category9);
        return successReturnObject(categories);
    }
}
