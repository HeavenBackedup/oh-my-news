package com.oh.my.news.model.vo.detail;

import com.oh.my.news.model.vo.edit.Category;

/**
 * Created by Prometheus on 2017/4/24.
 */
public class Article {//文章、作者、分类组合在一起的总信息
    private int id;
    private ArticleInfo articleInfo;
    private User user;
    private Category category;

    public Article() {
        super();
    }

    public Article(int id, ArticleInfo articleInfo, User user, Category category) {
        this.id = id;
        this.articleInfo = articleInfo;
        this.user = user;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleInfo=" + articleInfo +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
