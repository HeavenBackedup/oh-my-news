package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.dto.Image;

import java.io.File;
import java.io.InputStream;

/**
 * Created by shj on 2017/4/13.
 */
public interface ImageWriteManage {
    Image saveImageReturnId(InputStream inputStream)throws Exception;
}
