package com.oh.my.news.business.read.manage;

import com.oh.my.news.model.po.File;

/**
 * Created by shj on 2017/4/13.
 */
public interface ImageReadManage {
    File getImageById(Integer id)throws Exception;
}
