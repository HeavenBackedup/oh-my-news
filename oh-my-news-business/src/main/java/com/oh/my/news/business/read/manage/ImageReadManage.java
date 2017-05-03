package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.dto.Image;
import com.oh.my.news.model.po.File;

import java.util.List;

/**
 * Created by shj on 2017/4/13.
 */
public interface ImageReadManage {
    /**
     *
     * @param id 图片对应的id
     * @return
     * @throws Exception
     */
    File getImageById(Integer id)throws Exception;

    /**
     *
     * @param articleId 该文章的id
     * @return  通过该文章的id返回该文章对应的图片list
     * @throws Exception
     */
    List<Image> getImagesByArticleId(int articleId)throws Exception;



}
