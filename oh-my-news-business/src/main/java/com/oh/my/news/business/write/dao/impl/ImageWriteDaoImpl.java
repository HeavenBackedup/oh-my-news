package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.ImageWriteDao;
import com.oh.my.news.model.po.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/4/13.
 */
@Repository
public class ImageWriteDaoImpl implements ImageWriteDao{

    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public Integer insertImageReturnId(File file) throws Exception {
        return (Integer) sqlMapClient.insert("image_sqlMap.insert_image",file);
    }
}
