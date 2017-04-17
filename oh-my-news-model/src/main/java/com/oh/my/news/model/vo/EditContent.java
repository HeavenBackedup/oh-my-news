package com.oh.my.news.model.vo;

/**
 * Created by shj on 2017/4/16.
 */
public class EditContent {
    private String topic;
    private String htmlContent;
    private String labels;
    private int categoryId;


    public EditContent(String topic, String htmlContent, String labels, int categoryId) {
        this.topic = topic;
        this.htmlContent = htmlContent;
        this.labels = labels;
        this.categoryId = categoryId;
    }


    public EditContent() {
    }

    @Override
    public String
    toString() {
        return "EditContent{" +
                "topic='" + topic + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", labels='" + labels + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditContent that = (EditContent) o;

        if (categoryId != that.categoryId) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (htmlContent != null ? !htmlContent.equals(that.htmlContent) : that.htmlContent != null) return false;
        return labels != null ? labels.equals(that.labels) : that.labels == null;
    }

    @Override
    public int hashCode() {
        int result = topic != null ? topic.hashCode() : 0;
        result = 31 * result + (htmlContent != null ? htmlContent.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
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
}