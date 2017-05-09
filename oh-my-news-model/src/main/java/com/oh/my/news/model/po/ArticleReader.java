package com.oh.my.news.model.po;

/**
 * Created by Prometheus on 2017/5/9.
 */
public class ArticleReader {
    private int articleId;
    private int userId;
    private int score;
    private boolean report;
    private float donation;
    private boolean thumbUp;
    private boolean collected;

    public ArticleReader() {
    }

    public ArticleReader(int articleId, int userId, int score, boolean report, float donation, boolean thumbUp, boolean collected) {
        this.articleId = articleId;
        this.userId = userId;
        this.score = score;
        this.report = report;
        this.donation = donation;
        this.thumbUp = thumbUp;
        this.collected = collected;
    }

    public int getarticleId() {
        return articleId;
    }

    public void setarticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public float getDonation() {
        return donation;
    }

    public void setDonation(float donation) {
        this.donation = donation;
    }

    public boolean isThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(boolean thumbUp) {
        this.thumbUp = thumbUp;
    }

    public boolean iscollected() {
        return collected;
    }

    public void setcollected(boolean collected) {
        this.collected = collected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleReader that = (ArticleReader) o;

        if (articleId != that.articleId) return false;
        if (userId != that.userId) return false;
        if (score != that.score) return false;
        if (report != that.report) return false;
        if (Float.compare(that.donation, donation) != 0) return false;
        if (thumbUp != that.thumbUp) return false;
        return collected == that.collected;
    }

    @Override
    public int hashCode() {
        int result = articleId;
        result = 31 * result + userId;
        result = 31 * result + score;
        result = 31 * result + (report ? 1 : 0);
        result = 31 * result + (donation != +0.0f ? Float.floatToIntBits(donation) : 0);
        result = 31 * result + (thumbUp ? 1 : 0);
        result = 31 * result + (collected ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleReader{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", score=" + score +
                ", report=" + report +
                ", donation=" + donation +
                ", thumbUp=" + thumbUp +
                ", collected=" + collected +
                '}';
    }
}
