package com.oh.my.news.model.dto.search;

/**
 * Created by shj on 2017/4/27.
 */
public class SearchContent {
    private int id;
    private String topic;
    private String content;
    private String author;


    public SearchContent(int id, String topic, String content, String author) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.author = author;
    }

    public SearchContent() {
    }

    @Override
    public String toString() {
        return "SearchContent{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchContent that = (SearchContent) o;

        if (id != that.id) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return author != null ? author.equals(that.author) : that.author == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}

