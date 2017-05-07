package com.oh.my.news.web.controller;

import com.oh.my.news.business.write.manage.ImageWriteManage;
import com.oh.my.news.business.write.manage.impl.ImageWriteManageImpl;
import com.oh.my.news.model.dto.Image;
import com.oh.my.news.web.util.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by shj on 2017/4/14.
 */
@Controller
@RequestMapping(value = "/file")
public class FileAction extends BaseAction{


    @Autowired
    private ImageWriteManage imageWriteManage;

    private static Logger logger  = Logger.getLogger(FileAction.class);

    @RequestMapping(value = "/upload")
    @ResponseBody Object upload(@RequestParam(value = "file")MultipartFile file){
        if(file.isEmpty())
            return failReturnObject("file is empty");
        try {
            Image image =imageWriteManage.saveImageReturnId(file.getInputStream());
            if(image==null)
                return failReturnObject("upload failed,please retry");
            System.out.println(image);
            return successReturnObject(image);
        }catch (Exception e){
            logger.error(e.getMessage());
            return failReturnObject("upload failed,please retry");
        }

    }
}
