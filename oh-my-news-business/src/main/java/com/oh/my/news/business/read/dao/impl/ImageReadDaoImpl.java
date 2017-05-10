package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.ImageReadDao;
import com.oh.my.news.model.po.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.xml.ws.Action;
import java.util.List;

/**
 * Created by shj on 2017/4/13.
 */
@Repository
public class ImageReadDaoImpl implements ImageReadDao{

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public File queryImageById(Integer id) throws Exception {
        return (File) sqlMapClient.queryForObject("image_sqlMap.query_image",id);

    }

    @Override
    public List<File> QueryImageByArticleId(Integer articleId) throws Exception {
        return (List<File>) sqlMapClient.queryForList("image_sqlMap.query_image_by_article_id",articleId);
    }
}
