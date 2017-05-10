package com.oh.my.news.model.po;

import java.util.Date;

/**
 * Created by Prometheus on 2017/5/9.
 */
public class ArticleReaderType {
    private int id;
    private int isDelete;
    private int type;
    private float value;
    private Date date;
    private int articleId;
    private int userId;

//    type == 1 对文章评论comment
//    type == 2 对文章打分score    		 int
//    type == 3 对文章举报report             boolean
//    type == 4 对文章打赏donation           float
//    type == 5 对文章点赞thumbUp            boolean
//    type == 6 对文章收藏collected           boolean
//    type == 7 对文章浏览（次数）readed	boolean（int）

    public ArticleReaderType() {
    }

    public ArticleReaderType(int id, int isDelete, int type, float value, Date date, int articleId, int userId) {
        this.id = id;
        this.isDelete = isDelete;
        this.type = type;
        this.value = value;
        this.date = date;
        this.articleId = articleId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getarticleId() {
        return articleId;
    }

    public void setarticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleReaderType that = (ArticleReaderType) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (type != that.type) return false;
        if (Float.compare(that.value, value) != 0) return false;
        if (articleId != that.articleId) return false;
        if (userId != that.userId) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + type;
        result = 31 * result + (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + articleId;
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "ArticleReaderType{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", type=" + type +
                ", value=" + value +
                ", date=" + date +
                ", articleId=" + articleId +
                ", userId=" + userId +
                '}';
    }
}
