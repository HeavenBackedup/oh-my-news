package com.oh.my.news.model.vo.detail;

import java.util.List;

/**
 * Created by Prometheus on 2017/4/25.
 */
public class ArticalInfo {//文章的属性信息
    private int id;
    private String topic;
    private String htmlContent;
    private List<String> labels;
    private List<Artical> authorPost;
    private List<Artical> relatedPost;
    private int thumbupNum;
    private int readed;
    private String articalTime;
    private int commentNum;
    private float articalScore;

    public ArticalInfo() {
        super();
    }

    public ArticalInfo(int id, String topic, String htmlContent, List<String> labels, List<Artical> authorPost, List<Artical> relatedPost, int thumbupNum, int readed, String articalTime, int commentNum, float articalScore) {
        this.id = id;
        this.topic = topic;
        this.htmlContent = htmlContent;
        this.labels = labels;
        this.authorPost = authorPost;
        this.relatedPost = relatedPost;
        this.thumbupNum = thumbupNum;
        this.readed = readed;
        this.articalTime = articalTime;
        this.commentNum = commentNum;
        this.articalScore = articalScore;
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

    public List<Artical> getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(List<Artical> authorPost) {
        this.authorPost = authorPost;
    }

    public List<Artical> getRelatedPost() {
        return relatedPost;
    }

    public void setRelatedPost(List<Artical> relatedPost) {
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

    public String getArticalTime() {
        return articalTime;
    }

    public void setArticalTime(String articalTime) {
        this.articalTime = articalTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public float getArticalScore() {
        return articalScore;
    }

    public void setArticalScore(float articalScore) {
        this.articalScore = articalScore;
    }

    @Override
    public String toString() {
        return "ArticalInfo{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", labels=" + labels +
                ", authorPost=" + authorPost +
                ", relatedPost=" + relatedPost +
                ", thumbupNum=" + thumbupNum +
                ", readed=" + readed +
                ", articalTime='" + articalTime + '\'' +
                ", commentNum=" + commentNum +
                ", articalScore=" + articalScore +
                '}';
    }
}
