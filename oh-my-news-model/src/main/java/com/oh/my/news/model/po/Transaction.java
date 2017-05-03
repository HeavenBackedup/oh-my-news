package com.oh.my.news.model.po;
import java.util.Date;
/**
 * Created by shj on 2017/5/2.
 */
public class Transaction {
    private int id;
    private int isDelete;
    private int sourceUserId;
    private int targetUserId;
    private Date date;
    private float amount;
    private int articleId;

    public Transaction(int id, int isDelete, int sourceUserId, int targetUserId, Date date, float amount) {
        this.id = id;
        this.isDelete = isDelete;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.date = date;
        this.amount = amount;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (sourceUserId != that.sourceUserId) return false;
        if (targetUserId != that.targetUserId) return false;
        if (Float.compare(that.amount, amount) != 0) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + sourceUserId;
        result = 31 * result + targetUserId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        return result;
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

    public int getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(int sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
