package com.oh.my.news.model.vo.detail;

/**
 * Created by Prometheus on 2017/4/27.
 */
public class SubmitComment {//    这是用户提交的评论
    private int id;
    private User replier;
    private Comment formerComment;
    private int articalId;
    //    private User formerReplier;
    private String date;
    private String content;



    public SubmitComment(int id, User replier, Comment formerComment, int articalId, String date, String content) {
        this.id = id;
        this.replier = replier;
        this.formerComment = formerComment;
        this.articalId = articalId;
        this.date = date;
        this.content = content;
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

    public int getArticalId() {
        return articalId;
    }

    public void setArticalId(int articalId) {
        this.articalId = articalId;
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
        return "SubmitComment{" +
                "id=" + id +
                ", replier=" + replier +
                ", formerComment=" + formerComment +
                ", articalId=" + articalId +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
