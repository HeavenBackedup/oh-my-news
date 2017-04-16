package com.oh.my.news.web.controller;

import com.oh.my.news.model.dto.Image;
import com.oh.my.news.model.vo.EditContent;
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
@RequestMapping(value = "/edit")
@Controller
public class EditController extends BaseAction{


    @RequestMapping(value = "/getPics")
    public @ResponseBody Object getPics(@RequestBody  Map picMap){
        int userId =  (Integer) picMap.get("userId");
        int article =  (Integer) picMap.get("articleId");
        if(userId==-1)
            return failReturnObject("userId is missing");
        if(article==-1){
            List<Image> images = new ArrayList<Image>();
            images.add(new Image(3,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D"));
            images.add(new Image(4,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105228958_1?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=3gA%2BJohAw18jKqhHSCoyhgMj9MQ%3D"));
            images.add(new Image(5,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105281826_2?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=%2B3Q2dKk8KlxgAwkEkh8yAFxQq1o%3D"));
            return successReturnObject(images);
        }else {
            return null;
        }
    }


    @RequestMapping(value = "/editCommit")
    public @ResponseBody Object commit(@RequestBody EditContent editContent){
        System.out.println(editContent);
        return successReturnObject("save_success");
    }

    @RequestMapping(value = "/publish")
    public @ResponseBody Object publish(@RequestBody EditContent editContent){
        System.out.println(editContent);
        return successReturnObject("publish_success");
    }

}
