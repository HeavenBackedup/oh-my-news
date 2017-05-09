package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Category;
import com.oh.my.news.model.po.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public class ArticleDto{
    private Pagination pagination;
    private List<ArticleCategoryDto> article;


    public ArticleDto(Pagination pagination, List<ArticleCategoryDto> article) {
        this.pagination = pagination;
        this.article = article;
    }

    public ArticleDto() {
        this.article = new ArrayList<ArticleCategoryDto>();
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "pagination=" + pagination +
                ", article=" + article +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDto that = (ArticleDto) o;

        if (pagination != null ? !pagination.equals(that.pagination) : that.pagination != null) return false;
        return article != null ? article.equals(that.article) : that.article == null;
    }

    @Override
    public int hashCode() {
        int result = pagination != null ? pagination.hashCode() : 0;
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<ArticleCategoryDto> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleCategoryDto> article) {
        this.article = article;
    }

}
