package com.oh.my.news.model.po;
import java.util.Date;
/**
 * Created by shj on 2017/5/2.
 */
public class Comment {
    private int id;
    private int isDelete;
    private int userId;
    private int formerCommentId;
    private String content;
    private Date date;
    private int articleId;
    private int rootCommentId;

    public Comment(int id, int isDelete, int userId, int formerCommentId, String content, Date date, int articleId, int rootCommentId) {
        this.id = id;
        this.isDelete = isDelete;
        this.userId = userId;
        this.formerCommentId = formerCommentId;
        this.content = content;
        this.date = date;
        this.articleId = articleId;
        this.rootCommentId = rootCommentId;
    }

    public Comment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (isDelete != comment.isDelete) return false;
        if (userId != comment.userId) return false;
        if (formerCommentId != comment.formerCommentId) return false;
        if (articleId != comment.articleId) return false;
        if (rootCommentId != comment.rootCommentId) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        return date != null ? date.equals(comment.date) : comment.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + userId;
        result = 31 * result + formerCommentId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + articleId;
        result = 31 * result + rootCommentId;
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", userId=" + userId +
                ", formerCommentId=" + formerCommentId +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", articleId=" + articleId +
                ", rootCommentId=" + rootCommentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFormerCommentId() {
        return formerCommentId;
    }

    public void setFormerCommentId(int formerCommentId) {
        this.formerCommentId = formerCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(int rootCommentId) {
        this.rootCommentId = rootCommentId;
    }
}
