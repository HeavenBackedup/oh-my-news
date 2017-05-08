package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Category;
import com.oh.my.news.model.po.User;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public class ArticleDto{
    private Pagination pagination;
    private List<ArticleCategoryDto> article;
    private UserSnapshot userSnapshot;


    public ArticleDto(Pagination pagination, List<ArticleCategoryDto> article, UserSnapshot userSnapshot) {
        this.pagination = pagination;
        this.article = article;
        this.userSnapshot = userSnapshot;
    }
    public ArticleDto() {
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "pagination=" + pagination +
                ", article=" + article +
                ", userSnapshot=" + userSnapshot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDto that = (ArticleDto) o;

        if (pagination != null ? !pagination.equals(that.pagination) : that.pagination != null) return false;
        if (article != null ? !article.equals(that.article) : that.article != null) return false;
        return userSnapshot != null ? userSnapshot.equals(that.userSnapshot) : that.userSnapshot == null;
    }

    @Override
    public int hashCode() {
        int result = pagination != null ? pagination.hashCode() : 0;
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (userSnapshot != null ? userSnapshot.hashCode() : 0);
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

    public UserSnapshot getUserSnapshot() {
        return userSnapshot;
    }

    public void setUserSnapshot(UserSnapshot userSnapshot) {
        this.userSnapshot = userSnapshot;
    }
}
