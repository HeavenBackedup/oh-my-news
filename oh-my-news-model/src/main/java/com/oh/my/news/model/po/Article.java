package com.oh.my.news.model.po;

/**
 * Created by shj on 2017/5/1.
 */
public class Article {
    private int id;
    private int isDelete;
    private int userId;
    private String topic;
    private String content;
    private String labels;
    private int categoryId;
    private int isPublished;
    private String contentSnapshot;

    public Article(int id, int isDelete, int userId, String topic, String content, String labels, int categoryId, int isPublished, String contentSnapshot) {
        this.id = id;
        this.isDelete = isDelete;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.labels = labels;
        this.categoryId = categoryId;
        this.isPublished = isPublished;
        this.contentSnapshot = contentSnapshot;
    }



    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", userId=" + userId +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", labels='" + labels + '\'' +
                ", categoryId=" + categoryId +
                ", isPublished=" + isPublished +
                ", contentSnapshot='" + contentSnapshot + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (isDelete != article.isDelete) return false;
        if (userId != article.userId) return false;
        if (categoryId != article.categoryId) return false;
        if (isPublished != article.isPublished) return false;
        if (topic != null ? !topic.equals(article.topic) : article.topic != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (labels != null ? !labels.equals(article.labels) : article.labels != null) return false;
        return contentSnapshot != null ? contentSnapshot.equals(article.contentSnapshot) : article.contentSnapshot == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + userId;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + isPublished;
        result = 31 * result + (contentSnapshot != null ? contentSnapshot.hashCode() : 0);
        return result;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(int isPublished) {
        this.isPublished = isPublished;
    }

    public String getContentSnapshot() {
        return contentSnapshot;
    }

    public void setContentSnapshot(String contentSnapshot) {
        this.contentSnapshot = contentSnapshot;
    }
}
