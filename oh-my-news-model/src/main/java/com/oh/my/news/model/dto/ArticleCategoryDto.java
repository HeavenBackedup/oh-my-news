package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Category;

import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public class ArticleCategoryDto {

    private Article article;
    private Category category;
    List<Image> images;
    public ArticleCategoryDto(Article article, Category category, List<Image> images) {
        this.article = article;
        this.category = category;
        this.images = images;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ArticleCategoryDto{" +
                "article=" + article +
                ", category=" + category +
                ", images=" + images +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCategoryDto that = (ArticleCategoryDto) o;

        if (article != null ? !article.equals(that.article) : that.article != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return images != null ? images.equals(that.images) : that.images == null;
    }

    @Override
    public int hashCode() {
        int result = article != null ? article.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }
}
