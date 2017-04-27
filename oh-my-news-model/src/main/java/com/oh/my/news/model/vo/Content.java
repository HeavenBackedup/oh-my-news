package com.oh.my.news.model.vo;

/**
 * Created by leilei on 2017/4/20.
 */
public class Content {
    private String topic;
    private String  author;
    private String article;

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

    public Content(String topic, String author, String article){
        this.topic=topic;
        this.author=author;
        this.article=article;
    }
    public Content(){

    }

    @Override
    public String toString() {
        return "Content{" +
                "topic='" + topic + '\'' +
                ", author='" + author + '\'' +
                ", article='" + article + '\'' +
                '}';
    }
}
