package com.oh.my.news.model.dto;

import java.util.Date;

/**
 * Created by shj on 2017/5/2.
 */
public class TransactionDto {
    private int id;
    private int isDelete;
    private int targetName;
    private Date date;
    private float amount;


    public TransactionDto(int id, int isDelete, int targetName, Date date, float amount) {
        this.id = id;
        this.isDelete = isDelete;
        this.targetName = targetName;
        this.date = date;
        this.amount = amount;
    }


    public TransactionDto() {
    }


    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", targetName=" + targetName +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDto that = (TransactionDto) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (targetName != that.targetName) return false;
        if (Float.compare(that.amount, amount) != 0) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + targetName;
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

    public int getTargetName() {
        return targetName;
    }

    public void setTargetName(int targetName) {
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
}
