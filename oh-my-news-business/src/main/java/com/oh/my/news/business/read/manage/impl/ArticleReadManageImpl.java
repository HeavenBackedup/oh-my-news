package com.oh.my.news.business.read.manage.impl;


import com.oh.my.news.business.read.dao.ArticleReadDao;
import com.oh.my.news.business.read.dao.CategoryReadDao;
import com.oh.my.news.business.read.dao.ImageReadDao;
import com.oh.my.news.business.read.dao.UserReadDao;
import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.model.dto.*;
import com.oh.my.news.model.po.*;
import com.oh.my.news.model.po.ArticleReader;
import com.oh.my.news.search.api.SearchContentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prometheus on 2017/5/7.
 */
@Service
public class ArticleReadManageImpl implements ArticleReadManage{
    @Autowired
    private ArticleReadDao articleReadDao;
    @Autowired
    private UserReadDao userReadDao;
    @Autowired
    private ImageReadDao imageReadDao;
    @Autowired
    private CategoryReadDao categoryReadDao;
    @Autowired
    private SearchContentApi searchContentApi;

    public ArticleDto getHistoryArticles(int userId, int currentPage, int pageItemNum)throws Exception{
//        ArticleDto articleDto = new ArticleDto();
//        int totalItem = articleReadDao.getHistoryArticlesCountByUserId(userId);
//        Pagination pagination = new Pagination((totalItem%pageItemNum==0?totalItem/pageItemNum:totalItem/pageItemNum+1)*10,currentPage);
//        UserSnapshot userSnapshot = userReadDao.getUserSnapshotById(userId);
//        articleDto.setPagination(pagination);
//
//        List<Article> historyArticles = articleReadDao.getHistoryArticlesByUserId(userId,currentPage,pageItemNum);
//        for (Article hA:historyArticles){
//            ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
//            List<File> files = imageReadDao.QueryImageByArticleId(hA.getId());
//            List<Image> images = new ArrayList<Image>();
//            for (File file:files){
//                Image image = new Image();
//                image.setId(file.getId());
//                image.setUrl(file.getUrl());
//                images.add(image);
//            }
//            articleCategoryDto.setImages(images);
//            articleCategoryDto.setCategory(categoryReadDao.getCategoryById(hA.getCategoryId()));
//            articleCategoryDto.setArticle(hA);
//            articleCategoryDto.setUserSnapshot(userSnapshot);
//
//            articleDto.getArticle().add(articleCategoryDto);
//        }
        int totalItem = articleReadDao.getHistoryArticlesCountByUserId(userId);
        List<Article> historyArticles = articleReadDao.getHistoryArticlesByUserId(userId,currentPage,pageItemNum);
        return articleDtoPackage(totalItem,pageItemNum,currentPage,historyArticles);
    }

    public ArticleDto getCollectedArticles(int userId,int currentPage,int pageItemNum)throws Exception{
//        ArticleDto articleDto = new ArticleDto();
//        int totalItem = articleReadDao.getCollectedArticlesCountByUserId(userId);
//        Pagination pagination = new Pagination((totalItem%pageItemNum==0?totalItem/pageItemNum:totalItem/pageItemNum+1)*10,currentPage);
//        articleDto.setPagination(pagination);
//
//        List<Article> collectedArticles = articleReadDao.getCollectedArticlesByUserId(userId,currentPage,pageItemNum);
////        System.out.println("smy......."+collectedArticles);
//        for (Article cA:collectedArticles){
//            ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
//            List<File> files = imageReadDao.QueryImageByArticleId(cA.getId());
//            List<Image> images = new ArrayList<Image>();
//            for (File file:files){
//                Image image = new Image();
//                image.setId(file.getId());
//                image.setUrl(file.getUrl());
//                images.add(image);
//            }
//            articleCategoryDto.setImages(images);
//            articleCategoryDto.setCategory(categoryReadDao.getCategoryById(cA.getCategoryId()));
//            articleCategoryDto.setArticle(cA);
//            articleCategoryDto.setUserSnapshot(userReadDao.getUserSnapshotById(cA.getUserId()));
//
//            articleDto.getArticle().add(articleCategoryDto);
//        }\
        int totalItem = articleReadDao.getCollectedArticlesCountByUserId(userId);
        List<Article> collectedArticles = articleReadDao.getCollectedArticlesByUserId(userId,currentPage,pageItemNum);
        return articleDtoPackage(totalItem,pageItemNum,currentPage,collectedArticles);

    }

    public ArticleDto getDraftArticles(int userId,int currentPage,int pageItemNum)throws Exception{
        ArticleDto articleDto = new ArticleDto();
        int totalItem = articleReadDao.getDraftArticlesCountByUserId(userId);
        Pagination pagination = new Pagination((totalItem%pageItemNum==0?totalItem/pageItemNum:totalItem/pageItemNum+1)*10,currentPage);
        UserSnapshot userSnapshot = userReadDao.getUserSnapshotById(userId);
        articleDto.setPagination(pagination);

        List<Article> draftArticles = articleReadDao.getDraftArticlesByUserId(userId,currentPage,pageItemNum);
        for (Article dA:draftArticles){
            ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
            List<File> files = imageReadDao.QueryImageByArticleId(dA.getId());
//            List<Image> images = new ArrayList<Image>();
//            for (File file:files){
//                Image image = new Image();
//                image.setId(file.getId());
//                image.setUrl(file.getUrl());
//                images.add(image);
//            }
            articleCategoryDto.setImages(filesToImages(files));
            articleCategoryDto.setCategory(categoryReadDao.getCategoryById(dA.getCategoryId()));
            articleCategoryDto.setArticle(dA);
            articleCategoryDto.setUserSnapshot(userSnapshot);

            articleDto.getArticle().add(articleCategoryDto);
        }

        return articleDto;
    }

    public ArticleDetail getArticleDetail(int articleId,int userId)throws Exception{
        ArticleDetail articleDetail = new ArticleDetail();
        Article article = articleReadDao.getArticleById(articleId);
        ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
        List<File> files = imageReadDao.QueryImageByArticleId(articleId);
//        List<Image> images = new ArrayList<Image>();
//        for (File file:files){
//            Image image = new Image();
//            image.setId(file.getId());
//            image.setUrl(file.getUrl());
//            images.add(image);
//        }
        articleCategoryDto.setImages(filesToImages(files));
        articleCategoryDto.setCategory(categoryReadDao.getCategoryById(article.getCategoryId()));
        articleCategoryDto.setArticle(article);

        if (userId == -1){
            articleDetail.setArticleCategoryDto(articleCategoryDto);
            return articleDetail;
        }
        UserSnapshot userSnapshot = userReadDao.getUserSnapshotById(userId);
        ArticleReader articleReader = articleReadDao.getArticleReaderById(articleId,userId);
        articleCategoryDto.setUserSnapshot(userSnapshot);
        articleDetail.setArticleCategoryDto(articleCategoryDto);
        articleDetail.setcollected(articleReader.iscollected());
        articleDetail.setDonation(articleReader.getDonation());
        articleDetail.setReport(articleReader.isReport());
        articleDetail.setScore(articleReader.getScore());
        articleDetail.setThumbUp(articleReader.isThumbUp());



        return articleDetail;
    }

    public ArticleDto search(String text,int currentPage,int pageItemNum)throws Exception{
        List<Integer> articleIds = searchContentApi.search(text,(currentPage-1)*pageItemNum,pageItemNum);
        ArticleDto articleDto = new ArticleDto();
        Pagination pagination = new Pagination(0,currentPage);
        articleDto.setPagination(pagination);
        for (Integer articleId:articleIds){
            Article article = articleReadDao.getArticleById(articleId);
            if(article==null)
            continue;
            ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
            List<File> files = imageReadDao.QueryImageByArticleId(articleId);
//            List<Image> images = new ArrayList<Image>();
//            for (File file:files){
//                Image image = new Image();
//                image.setId(file.getId());
//                image.setUrl(file.getUrl());
//                images.add(image);
//            }

            articleCategoryDto.setImages(filesToImages(files));
            articleCategoryDto.setCategory(categoryReadDao.getCategoryById(article.getCategoryId()));
            articleCategoryDto.setArticle(article);
            articleCategoryDto.setUserSnapshot(userReadDao.getUserSnapshotById(article.getUserId()));

            articleDto.getArticle().add(articleCategoryDto);
        }
        return articleDto;
    }

    private ArticleDto articleDtoPackage(int totalItem,int pageItemNum,int currentPage,List<Article> articles)throws Exception{
        ArticleDto articleDto = new ArticleDto();
        Pagination pagination = new Pagination((totalItem%pageItemNum==0?totalItem/pageItemNum:totalItem/pageItemNum+1)*10,currentPage);

        articleDto.setPagination(pagination);
        for (Article cA:articles){
            ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
            List<File> files = imageReadDao.QueryImageByArticleId(cA.getId());
//            List<Image> images = new ArrayList<Image>();
//            for (File file:files){
//                Image image = new Image();
//                image.setId(file.getId());
//                image.setUrl(file.getUrl());
//                images.add(image);
//            }
            articleCategoryDto.setImages(filesToImages(files));
            articleCategoryDto.setCategory(categoryReadDao.getCategoryById(cA.getCategoryId()));
            articleCategoryDto.setArticle(cA);
            articleCategoryDto.setUserSnapshot(userReadDao.getUserSnapshotById(cA.getUserId()));

            articleDto.getArticle().add(articleCategoryDto);
        }
        return articleDto;
    }

    private List<Image> filesToImages(List<File> files){
        List<Image> images = new ArrayList<Image>();
        for (File file:files){
            Image image = new Image();
            image.setId(file.getId());
            image.setUrl(file.getUrl());
            images.add(image);
        }
        return images;
    }


    public ArticleDto getCollectedArticles(int userId, int currentPage, int pageItemNum, SortType sortType) throws Exception {
        int totalItem = articleReadDao.getCollectedArticlesCountByUserId(userId);
        List<Article> collectedArticles = articleReadDao.getCollectedArticlesByUserId(userId,currentPage,pageItemNum,sortType.getValue());
        return articleDtoPackage(totalItem,pageItemNum,currentPage,collectedArticles);    }


    public ArticleDto getHistoryArticles(int userId, int currentPage, int pageItemNum, SortType sortType) throws Exception {
        int totalItem = articleReadDao.getHistoryArticlesCountByUserId(userId);
        List<Article> collectedArticles = articleReadDao.getHistoryArticlesByUserId(userId,currentPage,pageItemNum,sortType.getValue());
        return articleDtoPackage(totalItem,pageItemNum,currentPage,collectedArticles);
    }

}

