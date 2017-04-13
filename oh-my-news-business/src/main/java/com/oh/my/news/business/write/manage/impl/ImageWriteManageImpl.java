package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.util.FileUtil;
import com.oh.my.news.business.write.dao.ImageWriteDao;
import com.oh.my.news.business.write.manage.ImageWriteManage;
import com.oh.my.news.model.dto.Image;

import com.oh.my.news.model.po.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.InputStream;

/**
 * Created by shj on 2017/4/13.
 */
@Service
public class ImageWriteManageImpl implements ImageWriteManage {

    @Autowired
    private ImageWriteDao imageWriteDao;

    @Autowired
    private FileUtil fileUtil;

    public Image saveImageReturnId(InputStream inputStream) throws Exception {
        File file = fileUtil.fileUpload(inputStream);
        if (file==null)
            return null;
        Integer id =imageWriteDao.insertImageReturnId(file);

        return new Image(id,file.getUrl());
    }
}
