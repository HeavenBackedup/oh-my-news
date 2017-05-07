package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.dao.impl.ImageReadDaoImpl;
import com.oh.my.news.business.write.dao.ImageWriteDao;
import com.oh.my.news.business.write.dao.impl.ImageWriteDaoImpl;
import com.oh.my.news.business.write.manage.impl.ImageWriteManageImpl;
import com.oh.my.news.model.po.File;
import com.oh.my.news.model.template.Item;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
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
        Thread thread = new Thread(new Runnable() {
            public void run() {

            }
        });
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

//    public void test(){
//        Map<String,Object> factory = new HashMap<String,Object>();
//        //factory build
//        factory.put("imgReadDao",new ImageReadDaoImpl());
//        factory.put("imageWriteDao",new ImageWriteDaoImpl());
//        factory.put("imageWriteDao_1", new ImageWriteDaoImpl());
//        factory.put("imageWriteManage",new ImageWriteManageImpl());
//        ...
//        factory.put("fileAction",new FileAction());
//
//
//        String type =  factory.get("fileAction").imageWriteManage.type;
//        String name = factory.get("fileAction").imageWriteManage.name;
//        if(type == ... || name == ...)
//        factory.get("fileAction").imageWriteManage = factory.get("imageWriteManage");
//    }


}
