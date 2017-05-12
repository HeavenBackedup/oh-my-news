package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.business.read.manage.ImageReadManage;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.manage.ArticleWriteManage;
import com.oh.my.news.model.dto.ArticleDetail;
import com.oh.my.news.model.dto.EditContentWrite;
import com.oh.my.news.model.dto.Image;
import com.oh.my.news.model.dto.UserFont;
import com.oh.my.news.model.po.File;
import com.oh.my.news.model.vo.edit.EditContent;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by shj on 2017/4/15.
 */
@RequestMapping(value = "/edit")
@Controller
public class EditAction extends BaseAction{

    @Autowired
    private ArticleWriteManage articleWriteManage;
    @Autowired
    private ArticleReadManage articleReadManage;
    @Autowired
    private UserReadManage userReadManage;

    @Autowired
    private ImageReadManage imageReadManage;
    @RequestMapping(value = "/getPics")
    public @ResponseBody Object getPics(@RequestBody  Map picMap)throws Exception{
        int userId =  (Integer) picMap.get("userId");
        int articleId =  (Integer) picMap.get("articleId");
        if(userId==-1)
            return failReturnObject("userId is missing");
        System.out.println(articleId);
//        if(articleId==-1){
//            List<Image> images = new ArrayList<Image>();
//            images.add(new Image(3,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D"));
//            images.add(new Image(4,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105228958_1?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=3gA%2BJohAw18jKqhHSCoyhgMj9MQ%3D"));
//            images.add(new Image(5,"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105281826_2?Expires=2122825175&OSSAccessKeyId=LTAImvg3z9iZRy2n&Signature=%2B3Q2dKk8KlxgAwkEkh8yAFxQq1o%3D"));
//            return successReturnObject(images);
//        }else {
//            return successReturnObject(null);
//        }
        if(articleId==-1)
            return successReturnObject(new ArrayList<Image>());
        List<File> files = imageReadManage.getImagesByArticleId(articleId);
        if(CollectionUtils.isEmpty(files))
            return successReturnObject(new ArrayList<Image>());
        List<Image> images = new ArrayList<Image>();
        for(File f:files){
            Image image = new Image();
            image.setId(f.getId());
            image.setUrl(f.getUrl());
            images.add(image);
        }
        return successReturnObject(images);

    }

    @RequestMapping(value = "/getArticle")
    public @ResponseBody Object getArticle(@RequestBody Map map)throws Exception{
        int articleId = (Integer) map.get("articleId");
        if(articleId == -1)
            throw new Exception("articleId is null");
        ArticleDetail articleDetail=articleReadManage.getArticleDetail(articleId,-1);
        EditContent content = new EditContent();
        content.setTopic(articleDetail.getArticleCategoryDto().getArticle().getTopic());
        content.setCategoryId(articleDetail.getArticleCategoryDto().getCategory().getId());
        content.setHtmlContent(articleDetail.getArticleCategoryDto().getArticle().getContent());
        content.setId(articleId);
        content.setLabels(articleDetail.getArticleCategoryDto().getArticle().getLabels());
        return successReturnObject(content);
    }


    @RequestMapping(value = "/editCommit")
    public @ResponseBody Object commit(@RequestBody EditContent editContent)throws Exception{
        EditContentWrite editContentWrite = new EditContentWrite();
        UserFont userFont = userReadManage.getUserDetail(editContent.getUserId());
        editContentWrite.setId(editContent.getId());
        editContentWrite.setLabels(editContent.getLabels());
        editContentWrite.setHtmlContent(editContent.getHtmlContent());
        editContentWrite.setContentSnapshot(editContent.getContentSnapshot());
        editContentWrite.setCategoryId(editContent.getCategoryId());
        editContentWrite.setMediaIds(editContent.getMediaIds());
        editContentWrite.setUserId(editContent.getUserId());
        editContentWrite.setTopic(editContent.getTopic());
        articleWriteManage.save(editContentWrite);
        return successReturnObject("save_success");
    }

    @RequestMapping(value = "/publish")
    public @ResponseBody Object publish(@RequestBody EditContent editContent)throws Exception{
        EditContentWrite editContentWrite = new EditContentWrite();
        UserFont userFont = userReadManage.getUserDetail(editContent.getUserId());
        editContentWrite.setId(editContent.getId());
        editContentWrite.setLabels(editContent.getLabels());
        editContentWrite.setHtmlContent(editContent.getHtmlContent());
        editContentWrite.setContentSnapshot(editContent.getContentSnapshot());
        editContentWrite.setCategoryId(editContent.getCategoryId());
        editContentWrite.setMediaIds(editContent.getMediaIds());
        editContentWrite.setUserId(editContent.getUserId());
        editContentWrite.setTopic(editContent.getTopic());
        int id =articleWriteManage.publish(editContentWrite);
        System.out.println("publish_id"+id);
        return successReturnObject(id);
    }

}
