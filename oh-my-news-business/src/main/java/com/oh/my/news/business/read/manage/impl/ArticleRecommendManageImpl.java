package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.ArticleRecommendDao;
import com.oh.my.news.business.read.manage.ArticleRecommendManage;
import com.oh.my.news.model.dto.ArticleSnapshot;
import com.oh.my.news.model.vo.mainpage.EditContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/4.
 */
@Service
public class ArticleRecommendManageImpl implements ArticleRecommendManage {
    @Autowired
    private ArticleRecommendDao articleRecommendDao;
    static final long TIME=1000000;

    //声明存放收藏排行，评论排行，最新动态的缓存
    private List<ArticleSnapshot> collectArticleSnapshot;
    private List<ArticleSnapshot> markArticleSnapshot;
    private List<ArticleSnapshot> lastArticleSnapshot;
//    private List<EditContent> mainArticleSnapshotByCategoryId;



    @PostConstruct
    public void init(){
        //启动线程对数据库进行查询操作，更新收藏排行，评论排行，最新动态
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        collectArticleSnapshot=articleRecommendDao.queryCollectList();
                        markArticleSnapshot=articleRecommendDao.queryMarkList();
                        lastArticleSnapshot=articleRecommendDao.queryLastList();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            Thread.sleep(TIME);
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }

                    }
                }
            }
        });
        thread.start();
    }


    public List<ArticleSnapshot> getCollect()throws Exception{
      return this.collectArticleSnapshot;
    }

    public List<ArticleSnapshot> getMark()throws Exception{
        return this.markArticleSnapshot;
    }

    public List<ArticleSnapshot> getLast()throws Exception{
        return this.lastArticleSnapshot;
    }

    public List<EditContent> getRecommendByCategoryId( int categoryId,  int currentPage, int pageItemNum)throws Exception{
      return articleRecommendDao.queryRecommendByCategoryId(categoryId,currentPage,pageItemNum);

    }



}
