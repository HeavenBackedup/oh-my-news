package com.oh.my.news.model.dto;

import com.oh.my.news.model.vo.detail.Artical;
import com.oh.my.news.model.vo.detail.User;

/**
 * Created by Prometheus on 2017/4/28.
 */
public class ArticalReader {
    private User reader;
    private Artical artical;
    private int score;
    private boolean report;
    private float donation;
    private boolean thumbUp;
    private boolean colleted;

    public ArticalReader() {
    }

    public ArticalReader(User reader, Artical artical, int score, boolean report, float donation, boolean thumbUp, boolean colleted) {
        this.reader = reader;
        this.artical = artical;
        this.score = score;
        this.report = report;
        this.donation = donation;
        this.thumbUp = thumbUp;
        this.colleted = colleted;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public Artical getArtical() {
        return artical;
    }

    public void setArtical(Artical artical) {
        this.artical = artical;
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

    public boolean isColleted() {
        return colleted;
    }

    public void setColleted(boolean colleted) {
        this.colleted = colleted;
    }

    @Override
    public String toString() {
        return "ArticalReader{" +
                "reader=" + reader +
                ", artical=" + artical +
                ", score=" + score +
                ", report=" + report +
                ", donation=" + donation +
                ", thumbUp=" + thumbUp +
                ", colleted=" + colleted +
                '}';
    }
}
