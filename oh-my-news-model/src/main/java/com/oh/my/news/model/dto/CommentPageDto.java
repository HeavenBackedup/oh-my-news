package com.oh.my.news.model.dto;


import java.util.List;

/**
 * Created by shj on 2017/5/3.
 */
public class CommentPageDto {

    private List<List<CommentDto>> comments;
    private Pagination pagination;
    public CommentPageDto(List<List<CommentDto>> comments, Pagination pagination) {
        this.comments = comments;
        this.pagination = pagination;
    }
    public CommentPageDto() {
    }

    @Override
    public String toString() {
        return "CommentPageDto{" +
                "comments=" + comments +
                ", pagination=" + pagination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentPageDto that = (CommentPageDto) o;

        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        return pagination != null ? pagination.equals(that.pagination) : that.pagination == null;
    }

    @Override
    public int hashCode() {
        int result = comments != null ? comments.hashCode() : 0;
        result = 31 * result + (pagination != null ? pagination.hashCode() : 0);
        return result;
    }

    public List<List<CommentDto>> getComments() {
        return comments;
    }

    public void setComments(List<List<CommentDto>> comments) {
        this.comments = comments;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
