package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.File;

/**
 * Created by shj on 2017/4/13.
 */
public interface ImageWriteDao {
    Integer insertImageReturnId(File file)throws Exception;
}
