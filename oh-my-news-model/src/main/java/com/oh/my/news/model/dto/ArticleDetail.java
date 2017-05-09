package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.User;

/**
 * Created by shj on 2017/5/4.
 */
public class ArticleDetail {
    private ArticleCategoryDto articleCategoryDto;
    private int score;
    private boolean report;
    private float donation;
    private boolean thumbUp;
    private boolean collected;

    public ArticleDetail(ArticleCategoryDto articleCategoryDto, int score, boolean report, float donation, boolean thumbUp, boolean collected) {
        this.articleCategoryDto = articleCategoryDto;
        this.score = score;
        this.report = report;
        this.donation = donation;
        this.thumbUp = thumbUp;
        this.collected = collected;
    }

    public ArticleDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDetail that = (ArticleDetail) o;

        if (score != that.score) return false;
        if (report != that.report) return false;
        if (Float.compare(that.donation, donation) != 0) return false;
        if (thumbUp != that.thumbUp) return false;
        if (collected != that.collected) return false;
        return articleCategoryDto != null ? articleCategoryDto.equals(that.articleCategoryDto) : that.articleCategoryDto == null;
    }

    @Override
    public int hashCode() {
        int result = articleCategoryDto != null ? articleCategoryDto.hashCode() : 0;
        result = 31 * result + score;
        result = 31 * result + (report ? 1 : 0);
        result = 31 * result + (donation != +0.0f ? Float.floatToIntBits(donation) : 0);
        result = 31 * result + (thumbUp ? 1 : 0);
        result = 31 * result + (collected ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleDetail{" +
                "articleCategoryDto=" + articleCategoryDto +
                ", score=" + score +
                ", report=" + report +
                ", donation=" + donation +
                ", thumbUp=" + thumbUp +
                ", collected=" + collected +
                '}';
    }

    public ArticleCategoryDto getArticleCategoryDto() {
        return articleCategoryDto;
    }

    public void setArticleCategoryDto(ArticleCategoryDto articleCategoryDto) {
        this.articleCategoryDto = articleCategoryDto;
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
}
