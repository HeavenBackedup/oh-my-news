package com.oh.my.news.model.vo.detail;

/**
 * Created by Prometheus on 2017/4/27.
 */
public class UserSubmitInfo {/////用户是否已打赏、已收藏等信息
    private User user;
    private boolean colleted;
    private boolean thumbUp;
    private float donation;
    private boolean report;
    private int score;
    private SubmitComment submitComment;

    public UserSubmitInfo() {
    }

    public UserSubmitInfo(User user, boolean colleted, boolean thumbUp, float donation, boolean report, int score, SubmitComment submitComment) {
        this.user = user;
        this.colleted = colleted;
        this.thumbUp = thumbUp;
        this.donation = donation;
        this.report = report;
        this.score = score;
        this.submitComment = submitComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isColleted() {
        return colleted;
    }

    public void setColleted(boolean colleted) {
        this.colleted = colleted;
    }

    public boolean isThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(boolean thumbUp) {
        this.thumbUp = thumbUp;
    }

    public float getDonation() {
        return donation;
    }

    public void setDonation(float donation) {
        this.donation = donation;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SubmitComment getSubmitComment() {
        return submitComment;
    }

    public void setSubmitComment(SubmitComment submitComment) {
        this.submitComment = submitComment;
    }

    @Override
    public String toString() {
        return "UserSubmitInfo{" +
                "user=" + user +
                ", colleted=" + colleted +
                ", thumbUp=" + thumbUp +
                ", donation=" + donation +
                ", report=" + report +
                ", score=" + score +
                ", submitComment=" + submitComment +
                '}';
    }
}
