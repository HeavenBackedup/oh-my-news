package com.oh.my.news.model.vo.detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prometheus on 2017/4/24.
 */
public class RootComments {///一篇文章的根评论
    private boolean unfold;
    private List<Comment> comments;

    public RootComments(boolean unfold, List<Comment> comments) {
        this.unfold = unfold;
        this.comments = comments;
    }

    public RootComments() {
        this.comments = new ArrayList<Comment>();
    }

    public boolean isUnfold() {
        return unfold;
    }

    public void setUnfold(boolean unfold) {
        this.unfold = unfold;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RootComments{" +
                "unfold=" + unfold +
                ", comments=" + comments +
                '}';
    }
}
