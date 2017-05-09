package com.oh.my.news.model.vo.detail;

/**
 * Created by Prometheus on 2017/4/28.
 */
public class ArticleReader {//读者对文章已做的操作
    private User reader;
    private Article article;
    private int score;
    private boolean report;
    private float donation;
    private boolean thumbUp;
    private boolean collected;

    public ArticleReader() {
    }

    public ArticleReader(User reader, Article article, int score, boolean report, float donation, boolean thumbUp, boolean collected) {
        this.reader = reader;
        this.article = article;
        this.score = score;
        this.report = report;
        this.donation = donation;
        this.thumbUp = thumbUp;
        this.collected = collected;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
    public String toString() {
        return "ArticleReader{" +
                "reader=" + reader +
                ", article=" + article +
                ", score=" + score +
                ", report=" + report +
                ", donation=" + donation +
                ", thumbUp=" + thumbUp +
                ", collected=" + collected +
                '}';
    }
}
