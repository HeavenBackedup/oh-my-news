package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Category;

/**
 * Created by shj on 2017/5/1.
 */
public class ArticleDto{
    private Category category;
    private Pagination pagination;
    private Article article;


    public ArticleDto(Category category, Pagination pagination, Article article) {
        this.category = category;
        this.pagination = pagination;
        this.article = article;
    }

    public ArticleDto() {
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "category=" + category +
                ", pagination=" + pagination +
                ", article=" + article +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDto that = (ArticleDto) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (pagination != null ? !pagination.equals(that.pagination) : that.pagination != null) return false;
        return article != null ? article.equals(that.article) : that.article == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (pagination != null ? pagination.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
