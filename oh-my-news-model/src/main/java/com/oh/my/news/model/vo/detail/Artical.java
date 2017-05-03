package com.oh.my.news.model.vo.detail;

import com.oh.my.news.model.vo.edit.Category;

/**
 * Created by Prometheus on 2017/4/24.
 */
public class Artical {//文章、作者、分类组合在一起的总信息
    private int id;
    private ArticalInfo articalInfo;
    private User user;
    private Category category;

    public Artical() {
        super();
    }

    public Artical(int id, ArticalInfo articalInfo, User user, Category category) {
        this.id = id;
        this.articalInfo = articalInfo;
        this.user = user;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticalInfo getArticalInfo() {
        return articalInfo;
    }

    public void setArticalInfo(ArticalInfo articalInfo) {
        this.articalInfo = articalInfo;
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
        return "Artical{" +
                "id=" + id +
                ", articalInfo=" + articalInfo +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
