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
    private int isLimit;
    private int score;
    private boolean report;
    private float donation;
    private boolean thumbUp;
    private boolean colleted;

    public Article(int id, int isDelete, int userId, String topic, String content, String labels, int categoryId, int isPublished, String contentSnapshot, int isLimit, int score, boolean report, float donation, boolean thumbUp, boolean colleted) {
        this.id = id;
        this.isDelete = isDelete;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.labels = labels;
        this.categoryId = categoryId;
        this.isPublished = isPublished;
        this.contentSnapshot = contentSnapshot;
        this.isLimit = isLimit;
        this.score = score;
        this.report = report;
        this.donation = donation;
        this.thumbUp = thumbUp;
        this.colleted = colleted;
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
                ", isLimit=" + isLimit +
                ", score=" + score +
                ", report=" + report +
                ", donation=" + donation +
                ", thumbUp=" + thumbUp +
                ", colleted=" + colleted +
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
        if (isLimit != article.isLimit) return false;
        if (score != article.score) return false;
        if (report != article.report) return false;
        if (Float.compare(article.donation, donation) != 0) return false;
        if (thumbUp != article.thumbUp) return false;
        if (colleted != article.colleted) return false;
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
        result = 31 * result + isLimit;
        result = 31 * result + score;
        result = 31 * result + (report ? 1 : 0);
        result = 31 * result + (donation != +0.0f ? Float.floatToIntBits(donation) : 0);
        result = 31 * result + (thumbUp ? 1 : 0);
        result = 31 * result + (colleted ? 1 : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public int getUserId() {
        return userId;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getLabels() {
        return labels;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public String getContentSnapshot() {
        return contentSnapshot;
    }

    public int getIsLimit() {
        return isLimit;
    }

    public int getScore() {
        return score;
    }

    public boolean isReport() {
        return report;
    }

    public float getDonation() {
        return donation;
    }

    public boolean isThumbUp() {
        return thumbUp;
    }

    public boolean isColleted() {
        return colleted;
    }
}

