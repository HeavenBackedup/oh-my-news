package com.oh.my.news.model.vo.detail;

/**
 * Created by Prometheus on 2017/4/21.
 */
public class Comment {//给前端显示的单个评论
    private int id;
    private User replier;
    private Comment formerComment;
    private int articleId;
//    private User formerReplier;
    private String date;
    private String content;
//    private int creply;////0,1,2表示几级评论
//    private List<Comment> comments;


    public Comment(int id, User replier, Comment formerComment, int articleId, String date, String content) {
        this.id = id;
        this.replier = replier;
        this.formerComment = formerComment;
        this.articleId = articleId;
        this.date = date;
        this.content = content;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReplier() {
        return replier;
    }

    public void setReplier(User replier) {
        this.replier = replier;
    }

    public Comment getFormerComment() {
        return formerComment;
    }

    public void setFormerComment(Comment formerComment) {
        this.formerComment = formerComment;
    }

    public int getarticleId() {
        return articleId;
    }

    public void setarticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", replier=" + replier +
                ", formerComment=" + formerComment +
                ", articleId=" + articleId +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}