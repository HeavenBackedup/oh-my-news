package com.oh.my.news.business.read.dao;

import com.oh.my.news.model.po.File;

import java.util.List;

/**
 * Created by shj on 2017/4/13.
 */
public interface ImageReadDao {
    File queryImageById(Integer id)throws Exception;
    List<File> QueryImageByArticleId(Integer articleId)throws Exception;
}
