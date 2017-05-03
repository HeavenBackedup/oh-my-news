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


    void thumUp(int userId,int articleId)throws Exception;

    void report(int userId,int articleId)throws Exception;

    void donate(int userId,int articleId,int num)throws Exception;

    void mark(int userId,int articleId,float score)throws Exception;

    void collect(int userId,int articleId)throws Exception;



    
    
}
