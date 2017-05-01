package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.vo.mainpage.EditContent;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleWriteManage {
    /**
     *
     * @param editContent
     * @throws Exception
     */
    void publish(EditContent editContent)throws Exception;

    /**
     *
     * @param editContent
     * @throws Exception
     */
    void save(EditContent editContent)throws Exception;
    
    
}
