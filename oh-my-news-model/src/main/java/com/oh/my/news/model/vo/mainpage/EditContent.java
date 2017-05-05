package com.oh.my.news.model.vo.mainpage;

/**
 * Created by shj on 2017/4/16.
 */
public class EditContent {
    private int id;
    private String author;
    private String date;
    private String topic;
    private String htmlContent;
    private String labels;
    private int categoryId;

    public EditContent(int id, String author, String date, String topic, String htmlContent, String labels, int categoryId) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.topic = topic;
        this.htmlContent = htmlContent;
        this.labels = labels;
        this.categoryId = categoryId;
    }

    public EditContent() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditContent that = (EditContent) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (htmlContent != null ? !htmlContent.equals(that.htmlContent) : that.htmlContent != null) return false;
        return labels != null ? labels.equals(that.labels) : that.labels == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (htmlContent != null ? htmlContent.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
    }

    @Override
    public String toString() {
        return "EditContent{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", topic='" + topic + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", labels='" + labels + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
