package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Article;
import com.oh.my.news.model.po.Category;

/**
 * Created by shj on 2017/5/1.
 */
public class ArticleDto extends Article{

    private Category category;

    public ArticleDto(int id, int isDelete, int userId, String topic, String content, String labels, int categoryId, int isPublished, Category category) {
        super(id, isDelete, userId, topic, content, labels, categoryId, isPublished);
        this.category = category;
    }

    public ArticleDto(Category category) {
        this.category = category;
    }

    public ArticleDto() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ArticleDto that = (ArticleDto) o;

        return category != null ? category.equals(that.category) : that.category == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "category=" + category +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
