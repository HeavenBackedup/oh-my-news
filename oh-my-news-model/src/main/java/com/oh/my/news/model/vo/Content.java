package com.oh.my.news.model.vo;

/**
 * Created by leilei on 2017/4/20.
 */
public class Content {
    private String topic;
    private String  author;
    private String article;
    private int id;

    public Content(String topic, String author, String article, int id) {
        this.topic = topic;
        this.author = author;
        this.article = article;
        this.id = id;
    }

    public Content() {
    }

    @Override
    public String toString() {
        return "Content{" +
                "topic='" + topic + '\'' +
                ", author='" + author + '\'' +
                ", article='" + article + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        if (id != content.id) return false;
        if (topic != null ? !topic.equals(content.topic) : content.topic != null) return false;
        if (author != null ? !author.equals(content.author) : content.author != null) return false;
        return article != null ? article.equals(content.article) : content.article == null;
    }

    @Override
    public int hashCode() {
        int result = topic != null ? topic.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
