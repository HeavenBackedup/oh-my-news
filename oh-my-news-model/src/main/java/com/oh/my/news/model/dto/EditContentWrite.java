package com.oh.my.news.model.dto;

import java.util.List;

/**
 * Created by shj on 2017/5/8.
 */
public class EditContentWrite {
    private int id;
    private int userId;
    private String topic;
    private String htmlContent;
    private String labels;
    private int categoryId;
    private String contentSnapshot;
    private List<Integer> mediaIds;

    public EditContentWrite(int id, int userId, String topic, String htmlContent, String labels, int categoryId, String contentSnapshot, List<Integer> mediaIds) {
        this.id = id;
        this.userId = userId;
        this.topic = topic;
        this.htmlContent = htmlContent;
        this.labels = labels;
        this.categoryId = categoryId;
        this.contentSnapshot = contentSnapshot;
        this.mediaIds = mediaIds;
    }

    public EditContentWrite() {
    }


    @Override
    public String toString() {
        return "EditContentWrite{" +
                "id=" + id +
                ", userId=" + userId +
                ", topic='" + topic + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", labels='" + labels + '\'' +
                ", categoryId=" + categoryId +
                ", contentSnapshot='" + contentSnapshot + '\'' +
                ", mediaIds=" + mediaIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditContentWrite that = (EditContentWrite) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (categoryId != that.categoryId) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (htmlContent != null ? !htmlContent.equals(that.htmlContent) : that.htmlContent != null) return false;
        if (labels != null ? !labels.equals(that.labels) : that.labels != null) return false;
        if (contentSnapshot != null ? !contentSnapshot.equals(that.contentSnapshot) : that.contentSnapshot != null)
            return false;
        return mediaIds != null ? mediaIds.equals(that.mediaIds) : that.mediaIds == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (htmlContent != null ? htmlContent.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + (contentSnapshot != null ? contentSnapshot.hashCode() : 0);
        result = 31 * result + (mediaIds != null ? mediaIds.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
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

    public String getContentSnapshot() {
        return contentSnapshot;
    }

    public void setContentSnapshot(String contentSnapshot) {
        this.contentSnapshot = contentSnapshot;
    }

    public List<Integer> getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(List<Integer> mediaIds) {
        this.mediaIds = mediaIds;
    }
}
