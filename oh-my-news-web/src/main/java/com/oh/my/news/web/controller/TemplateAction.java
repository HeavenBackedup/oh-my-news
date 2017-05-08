package com.oh.my.news.web.controller;

import com.oh.my.news.model.template.Item;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.oh.my.news.model.template.Pagination;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shj on 2017/4/11.
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateAction extends BaseAction {


    @RequestMapping(value = "/getInput",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object getInput(@RequestBody Map inputMap){
        System.out.println(inputMap);
        String input = inputMap.get("value").toString();

        String res = "data is recieved,repeat the data: "+input;
        return successReturnObject(res);
    }

    @RequestMapping(value = "/pageReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object pageReq(@RequestBody Map pageMap){
        System.out.println(pageMap);

        int currentPage = Integer.parseInt(pageMap.get("currentPage").toString().trim());
        Map<String,Object> map = new HashMap();
        map.put("pagination",new Pagination(200,currentPage));
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1,"shj"));
        itemList.add(new Item(2,"fdd"));
        itemList.add(new Item(3,"dzm"));
        itemList.add(new Item(4,"dz"));
        itemList.add(new Item(5,"tom"));
        map.put("items",itemList);
        return successReturnObject(map);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody Object fileUpload(@RequestParam(value = "file")MultipartFile file){
        String path="../../../../../../webapp/images/";
        System.out.println(file.getOriginalFilename());

        return successReturnObject("file get");
    }



}
