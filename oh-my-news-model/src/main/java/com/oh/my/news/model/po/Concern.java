package com.oh.my.news.model.po;
import java.util.Date;
/**
 * Created by shj on 2017/5/3.
 */
public class Concern {
    private int id;
    private int isDelete;
    private int sourceUserId;
    private int targetUserId;
    private Date date;


    public Concern(int id, int isDelete, int sourceUserId, int targetUserId, Date date) {
        this.id = id;
        this.isDelete = isDelete;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Concern{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", sourceUserId=" + sourceUserId +
                ", targetUserId=" + targetUserId +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concern concern = (Concern) o;

        if (id != concern.id) return false;
        if (isDelete != concern.isDelete) return false;
        if (sourceUserId != concern.sourceUserId) return false;
        if (targetUserId != concern.targetUserId) return false;
        return date != null ? date.equals(concern.date) : concern.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + sourceUserId;
        result = 31 * result + targetUserId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
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
}
