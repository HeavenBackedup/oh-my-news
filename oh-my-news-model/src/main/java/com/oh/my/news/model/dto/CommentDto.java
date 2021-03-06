package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.Comment;
import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/2.
 */
public class CommentDto {

    private Comment comment;
    private UserSnapshot replier;
    private Comment formerComment;
    private UserSnapshot formerReplier;


    public CommentDto(Comment comment, UserSnapshot replier, Comment formerComment, UserSnapshot formerReplier) {
        this.comment = comment;
        this.replier = replier;
        this.formerComment = formerComment;
        this.formerReplier = formerReplier;
    }

    public CommentDto(Comment comment, UserSnapshot replier, Comment formerComment) {
        this.comment = comment;
        this.replier = replier;
        this.formerComment = formerComment;
    }

    public CommentDto() {
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "comment=" + comment +
                ", replier=" + replier +
                ", formerComment=" + formerComment +
                ", formerReplier=" + formerReplier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentDto that = (CommentDto) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (replier != null ? !replier.equals(that.replier) : that.replier != null) return false;
        if (formerComment != null ? !formerComment.equals(that.formerComment) : that.formerComment != null)
            return false;
        return formerReplier != null ? formerReplier.equals(that.formerReplier) : that.formerReplier == null;
    }

    @Override
    public int hashCode() {
        int result = comment != null ? comment.hashCode() : 0;
        result = 31 * result + (replier != null ? replier.hashCode() : 0);
        result = 31 * result + (formerComment != null ? formerComment.hashCode() : 0);
        result = 31 * result + (formerReplier != null ? formerReplier.hashCode() : 0);
        return result;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public UserSnapshot getReplier() {
        return replier;
    }

    public void setReplier(UserSnapshot replier) {
        this.replier = replier;
    }

    public Comment getFormerComment() {
        return formerComment;
    }

    public void setFormerComment(Comment formerComment) {
        this.formerComment = formerComment;
    }

    public UserSnapshot getFormerReplier() {
        return formerReplier;
    }

    public void setFormerReplier(UserSnapshot formerReplier) {
        this.formerReplier = formerReplier;
    }
}
