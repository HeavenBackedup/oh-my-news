package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.vo.mainpage.EditContent;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleWriteManage {
    /**
     *  发表该新闻
     * @param editContent  编辑的新闻内容
     * @throws Exception
     */
    void publish(EditContent editContent)throws Exception;

    /**
     * 将新闻保存在草稿箱中
     * @param editContent
     * @throws Exception
     */
    void save(EditContent editContent)throws Exception;
    
    
}
