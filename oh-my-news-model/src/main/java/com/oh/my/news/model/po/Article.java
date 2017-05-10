package com.oh.my.news.model.po;
import java.util.Date;
/**
 * Created by shj on 2017/5/1.
 */
public class Article {
    private Integer id;
    private Integer isDelete;
    private Integer userId;
    private String topic;
    private String content;
    private String labels;
    private Integer categoryId;
    private Integer isPublished;
    private String contentSnapshot;
    private Integer isLimit;
    private Integer score;
    private Integer report;
    private float donation;
    private Integer thumbUp;
    private Integer collected;
    private Date date;
    private Integer mark_num;
    private Integer root_num;

    public Article(Integer id, Integer isDelete, Integer userId, String topic, String content, String labels, Integer categoryId, Integer isPublished, String contentSnapshot, Integer isLimit, Integer score, Integer report, float donation, Integer thumbUp, Integer collected, Date date, Integer mark_num, Integer root_num) {
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
        this.collected = collected;
        this.date = date;
        this.mark_num = mark_num;
        this.root_num = root_num;
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
                ", collected=" + collected +
                ", date=" + date +
                ", mark_num=" + mark_num +
                ", root_num=" + root_num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (Float.compare(article.donation, donation) != 0) return false;
        if (id != null ? !id.equals(article.id) : article.id != null) return false;
        if (isDelete != null ? !isDelete.equals(article.isDelete) : article.isDelete != null) return false;
        if (userId != null ? !userId.equals(article.userId) : article.userId != null) return false;
        if (topic != null ? !topic.equals(article.topic) : article.topic != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (labels != null ? !labels.equals(article.labels) : article.labels != null) return false;
        if (categoryId != null ? !categoryId.equals(article.categoryId) : article.categoryId != null) return false;
        if (isPublished != null ? !isPublished.equals(article.isPublished) : article.isPublished != null) return false;
        if (contentSnapshot != null ? !contentSnapshot.equals(article.contentSnapshot) : article.contentSnapshot != null)
            return false;
        if (isLimit != null ? !isLimit.equals(article.isLimit) : article.isLimit != null) return false;
        if (score != null ? !score.equals(article.score) : article.score != null) return false;
        if (report != null ? !report.equals(article.report) : article.report != null) return false;
        if (thumbUp != null ? !thumbUp.equals(article.thumbUp) : article.thumbUp != null) return false;
        if (collected != null ? !collected.equals(article.collected) : article.collected != null) return false;
        if (date != null ? !date.equals(article.date) : article.date != null) return false;
        if (mark_num != null ? !mark_num.equals(article.mark_num) : article.mark_num != null) return false;
        return root_num != null ? root_num.equals(article.root_num) : article.root_num == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (isPublished != null ? isPublished.hashCode() : 0);
        result = 31 * result + (contentSnapshot != null ? contentSnapshot.hashCode() : 0);
        result = 31 * result + (isLimit != null ? isLimit.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (donation != +0.0f ? Float.floatToIntBits(donation) : 0);
        result = 31 * result + (thumbUp != null ? thumbUp.hashCode() : 0);
        result = 31 * result + (collected != null ? collected.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (mark_num != null ? mark_num.hashCode() : 0);
        result = 31 * result + (root_num != null ? root_num.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public String getContentSnapshot() {
        return contentSnapshot;
    }

    public void setContentSnapshot(String contentSnapshot) {
        this.contentSnapshot = contentSnapshot;
    }

    public Integer getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(Integer isLimit) {
        this.isLimit = isLimit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public float getDonation() {
        return donation;
    }

    public void setDonation(float donation) {
        this.donation = donation;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public Integer getCollected() {
        return collected;
    }

    public void setCollected(Integer collected) {
        this.collected = collected;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMark_num() {
        return mark_num;
    }

    public void setMark_num(Integer mark_num) {
        this.mark_num = mark_num;
    }

    public Integer getRoot_num() {
        return root_num;
    }

    public void setRoot_num(Integer root_num) {
        this.root_num = root_num;
    }
}

