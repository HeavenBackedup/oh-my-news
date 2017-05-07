package com.oh.my.news.model.po;

import java.util.Date;

/**
 * Created by shj on 2017/5/2.
 */
public class TransactionPo {
    private int id;
    private int isDelete;
    private String targetName;
    private Date date;
    private float amount;
    private String message;


    public TransactionPo(int id, int isDelete, String targetName, Date date, float amount, String message) {
        this.id = id;
        this.isDelete = isDelete;
        this.targetName = targetName;
        this.date = date;
        this.amount = amount;
        this.message = message;
    }

    public TransactionPo() {
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", targetName='" + targetName + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                '}';
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

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionPo that = (TransactionPo) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (Float.compare(that.amount, amount) != 0) return false;
        if (!targetName.equals(that.targetName)) return false;
        if (!date.equals(that.date)) return false;
        return message.equals(that.message);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + targetName.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        result = 31 * result + message.hashCode();
        return result;
    }
}