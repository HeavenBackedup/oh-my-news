package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.ImageReadDao;
import com.oh.my.news.business.read.manage.ImageReadManage;
import com.oh.my.news.model.dto.Image;
import com.oh.my.news.model.po.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/4/13.
 */
@Service
public class ImageReadManageImpl implements ImageReadManage{
    @Autowired
    private ImageReadDao imageReadDao;

    public File getImageById(Integer id) throws Exception {
        return imageReadDao.queryImageById(id);
    }
    public List<File> getImagesByArticleId(int articleId) throws Exception {
        return  imageReadDao.QueryImageByArticleId(articleId);
    }
}
