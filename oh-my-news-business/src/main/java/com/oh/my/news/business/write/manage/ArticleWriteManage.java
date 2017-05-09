package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.dto.EditContentWrite;
import com.oh.my.news.model.vo.mainpage.EditContent;

/**
 * Created by shj on 2017/5/1.
 */
public interface ArticleWriteManage {
    /**
     *  发表该新闻
     * @param editContentWrite  编辑的新闻内容
     * @throws Exception
     */
    void publish(EditContentWrite editContentWrite)throws Exception;

    /**
     * 将新闻保存在草稿箱中
     * @param editContentWrite
     * @throws Exception
     */
    void save(EditContentWrite editContentWrite)throws Exception;

    /**
     * 某用户对某新闻点赞
     * @param userId  用户id
     * @param articleId  新闻id
     * @throws Exception
     */
    void thumUp(int userId,int articleId)throws Exception;

    /**
     * 某用户举报某新闻
     * @param userId
     * @param articleId
     * @throws Exception
     */
    void report(int userId,int articleId)throws Exception;

    /**
     * 某用户给某新闻打赏
     * @param userId
     * @param articleId
     * @param num 打赏金额
     * @throws Exception
     */

    void donate(int userId,int articleId,int num,String message)throws Exception;

    /**
     * 某用户给某新闻评分
     * @param userId
     * @param articleId
     * @param score 具体的评分分数
     * @throws Exception
     */
    void mark(int userId,int articleId,float score)throws Exception;

    /**
     * 某用户收藏某新闻
     * @param userId
     * @param articleId
     * @throws Exception
     */
    void collect(int userId,int articleId)throws Exception;



    
    
}
