package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.read.dao.ArticleReadDao;
import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.business.read.dao.WalletReadDao;
import com.oh.my.news.business.write.dao.ArticleWriteDao;
import com.oh.my.news.business.write.dao.TransactionWriteDao;
import com.oh.my.news.business.write.dao.WalletWriteDao;
import com.oh.my.news.business.write.manage.ArticleWriteManage;
import com.oh.my.news.model.dto.*;
import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.vo.edit.EditContent;
import com.oh.my.news.search.api.SearchContentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by shj on 2017/5/9.
 */
@Service
public class ArticleWriteManageImpl implements ArticleWriteManage{

    @Autowired
    private TransactionWriteDao transactionWriteDao;
    @Autowired
    private ArticleReadDao articleReadDao;
    @Autowired
    private ArticleWriteDao articleWriteDao;
//    @Autowired
//    private SearchContentApi searchContentApi;
    @Autowired
    private UserReadDao userReadDao;
    @Autowired
    private WalletWriteDao walletWriteDao;
    @Autowired
    private WalletReadDao walletReadDao;
    @Override
    public void collect(int userId, int articleId) throws Exception {
        articleWriteDao.insertUARelReturnId(userId,articleId,UARelTypeEnum.COLLECT.getType(),0.0f);
    }

    @Override
    public boolean donate(int userId, int articleId, int num, String message) throws Exception {
        int authorId = articleReadDao.queryUserIdById(articleId);

        synchronized (this){

            float figure = walletReadDao.getFigure(userId);
            if(figure<num)
                return false;
            transactionWriteDao.insertTransactionByIds(userId,articleId,num,articleId,message);
            walletWriteDao.updateWalletFigure(userId,-num);
            walletWriteDao.updateWalletFigure(authorId,+num);
            return true;
        }

    }

    @Override
    public void mark(int userId, int articleId, float score) throws Exception {
        if(articleWriteDao.ifOpDone(userId,articleId,UARelTypeEnum.MARK.getType()))
            throw new Exception("the user has already marked");
        articleWriteDao.insertUARelReturnId(userId,articleId, UARelTypeEnum.MARK.getType(),score);
    }

    @Override
    public Integer publish(EditContentWrite editContentWrite) throws Exception {
        Article article = new Article();
        article.setId(editContentWrite.getId());
        article.setTopic(editContentWrite.getTopic());
        article.setCategoryId(editContentWrite.getCategoryId());
        article.setContent(editContentWrite.getHtmlContent());
        article.setContentSnapshot(editContentWrite.getContentSnapshot());
        article.setLabels(editContentWrite.getLabels());
        article.setUserId(editContentWrite.getUserId());
        UserSnapshot userSnapshot =userReadDao.getUserSnapshotById(editContentWrite.getUserId());
        SearchContent searchContent = new SearchContent();

        searchContent.setAuthor(userSnapshot.getNickname());
        searchContent.setContent(editContentWrite.getContentSnapshot());
        searchContent.setTopic(editContentWrite.getTopic());
        if(editContentWrite.getId()<=0){
            article.setIsPublished(1);

            int id= articleWriteDao.insertArticleReturnId(article);
            articleWriteDao.saveMedia(editContentWrite.getMediaIds(),id);
            return id;
        }else {
            article.setIsPublished(1);
            articleWriteDao.saveArticle(article);
            articleWriteDao.saveMedia(editContentWrite.getMediaIds(),editContentWrite.getId());
            return article.getId();
        }
//        if(editContentWrite.getId()<=0){
//            article.setIsPublished(1);
//             int id= articleWriteDao.insertArticleReturnId(article);
//             articleWriteDao.saveMedia(editContentWrite.getMediaIds(),id);
//            searchContent.setId(id);
//            searchContentApi.insert(searchContent);
//        }else {
//            articleWriteDao.publishArticle(article);
//            articleWriteDao.saveMedia(editContentWrite.getMediaIds(),editContentWrite.getId());
//            searchContent.setId(editContentWrite.getId());
//            searchContentApi.insert(searchContent);
//        }

    }

    @Override
    public void report(int userId, int articleId) throws Exception {
        if(articleWriteDao.ifOpDone(userId,articleId,UARelTypeEnum.REPORT.getType()))
            throw new Exception("the user has already reported");
        articleWriteDao.insertUARelReturnId(userId, articleId,UARelTypeEnum.REPORT.getType(),0.0f);
    }

    @Override
    public void save(EditContentWrite editContentWrite) throws Exception {
        Article article = new Article();
        article.setId(editContentWrite.getId());
        article.setTopic(editContentWrite.getTopic());
        article.setCategoryId(editContentWrite.getCategoryId());
        article.setContent(editContentWrite.getHtmlContent());
        article.setContentSnapshot(editContentWrite.getContentSnapshot());
        article.setUserId(editContentWrite.getUserId());
        if(editContentWrite.getId()<=0){
            article.setIsPublished(0);

            int id= articleWriteDao.insertArticleReturnId(article);
            articleWriteDao.saveMedia(editContentWrite.getMediaIds(),id);
        }else {
            articleWriteDao.saveArticle(article);
            articleWriteDao.saveMedia(editContentWrite.getMediaIds(),editContentWrite.getId());
        }
    }

    @Override
    public void thumUp(int userId, int articleId) throws Exception {
        if(articleWriteDao.ifOpDone(userId,articleId,UARelTypeEnum.THUMBUP.getType()))
            throw new Exception("the user has already thumuped");
        articleWriteDao.insertUARelReturnId(userId,articleId,UARelTypeEnum.THUMBUP.getType(),0.0f);
    }

}
