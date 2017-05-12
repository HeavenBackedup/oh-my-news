package com.oh.my.news.model.po;
import java.util.Date;
/**
 * Created by shj on 2017/5/2.
 */
public class Transaction {
    private Integer id;
    private Integer isDelete;
    private Integer sourceUserId;
    private Integer targetUserId;
    private Date date;
    private Float amount;
    private Integer articleId;
    private String message;

    public Transaction(Integer id, Integer isDelete, Integer sourceUserId, Integer targetUserId, Date date, Float amount, Integer articleId, String message) {
        this.id = id;
        this.isDelete = isDelete;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.date = date;
        this.amount = amount;
        this.articleId = articleId;
        this.message = message;
    }

    public Transaction() {
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", sourceUserId=" + sourceUserId +
                ", targetUserId=" + targetUserId +
                ", date=" + date +
                ", amount=" + amount +
                ", articleId=" + articleId +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;
        if (sourceUserId != null ? !sourceUserId.equals(that.sourceUserId) : that.sourceUserId != null) return false;
        if (targetUserId != null ? !targetUserId.equals(that.targetUserId) : that.targetUserId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (sourceUserId != null ? sourceUserId.hashCode() : 0);
        result = 31 * result + (targetUserId != null ? targetUserId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Integer sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public Integer getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
