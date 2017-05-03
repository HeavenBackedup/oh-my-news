package com.oh.my.news.model.po;
import java.util.Date;
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
    private Date date;
    private int mark_num;

    public Article(int id, int isDelete, int userId, String topic, String content, String labels, int categoryId, int isPublished, String contentSnapshot, int isLimit, int score, boolean report, float donation, boolean thumbUp, boolean colleted, Date date, int mark_num) {
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
        this.date = date;
        this.mark_num = mark_num;
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
        if (mark_num != article.mark_num) return false;
        if (topic != null ? !topic.equals(article.topic) : article.topic != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (labels != null ? !labels.equals(article.labels) : article.labels != null) return false;
        if (contentSnapshot != null ? !contentSnapshot.equals(article.contentSnapshot) : article.contentSnapshot != null)
            return false;
        return date != null ? date.equals(article.date) : article.date == null;
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
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + mark_num;
        return result;
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
                ", date=" + date +
                ", mark_num=" + mark_num +
                '}';
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

    public int getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(int isLimit) {
        this.isLimit = isLimit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public float getDonation() {
        return donation;
    }

    public void setDonation(float donation) {
        this.donation = donation;
    }

    public boolean isThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(boolean thumbUp) {
        this.thumbUp = thumbUp;
    }

    public boolean isColleted() {
        return colleted;
    }

    public void setColleted(boolean colleted) {
        this.colleted = colleted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark_num() {
        return mark_num;
    }

    public void setMark_num(int mark_num) {
        this.mark_num = mark_num;
    }
}

