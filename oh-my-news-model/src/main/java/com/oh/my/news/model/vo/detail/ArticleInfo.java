package com.oh.my.news.model.vo.detail;

import java.util.List;

/**
 * Created by Prometheus on 2017/4/25.
 */
public class ArticleInfo {//文章的属性信息
    private int id;
    private String topic;
    private String htmlContent;
    private List<String> labels;
    private List<Article> authorPost;
    private List<Article> relatedPost;
    private int thumbupNum;
    private int readed;
    private String articleTime;
    private int commentNum;
    private float articleScore;

    public ArticleInfo() {
        super();
    }

    public ArticleInfo(int id, String topic, String htmlContent, List<String> labels, List<Article> authorPost, List<Article> relatedPost, int thumbupNum, int readed, String articleTime, int commentNum, float articleScore) {
        this.id = id;
        this.topic = topic;
        this.htmlContent = htmlContent;
        this.labels = labels;
        this.authorPost = authorPost;
        this.relatedPost = relatedPost;
        this.thumbupNum = thumbupNum;
        this.readed = readed;
        this.articleTime = articleTime;
        this.commentNum = commentNum;
        this.articleScore = articleScore;
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

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Article> getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(List<Article> authorPost) {
        this.authorPost = authorPost;
    }

    public List<Article> getRelatedPost() {
        return relatedPost;
    }

    public void setRelatedPost(List<Article> relatedPost) {
        this.relatedPost = relatedPost;
    }

    public int getThumbupNum() {
        return thumbupNum;
    }

    public void setThumbupNum(int thumbupNum) {
        this.thumbupNum = thumbupNum;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public String getarticleTime() {
        return articleTime;
    }

    public void setarticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public float getarticleScore() {
        return articleScore;
    }

    public void setarticleScore(float articleScore) {
        this.articleScore = articleScore;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", labels=" + labels +
                ", authorPost=" + authorPost +
                ", relatedPost=" + relatedPost +
                ", thumbupNum=" + thumbupNum +
                ", readed=" + readed +
                ", articleTime='" + articleTime + '\'' +
                ", commentNum=" + commentNum +
                ", articleScore=" + articleScore +
                '}';
    }
}
