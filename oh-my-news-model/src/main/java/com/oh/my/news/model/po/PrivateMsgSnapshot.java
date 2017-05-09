package com.oh.my.news.model.po;

import java.sql.Date;

/**
 * Created by shj on 2017/5/9.
 */
public class PrivateMsgSnapshot {
    private int id;
    private int targetId;
    private Date date;

    public PrivateMsgSnapshot(int id, int targetId, Date date) {
        this.id = id;
        this.targetId = targetId;
        this.date = date;
    }

    public PrivateMsgSnapshot() {
    }

    @Override
    public String toString() {
        return "PrivateMsgSnapshot{" +
                "id=" + id +
                ", targetId=" + targetId +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateMsgSnapshot that = (PrivateMsgSnapshot) o;

        if (id != that.id) return false;
        if (targetId != that.targetId) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + targetId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
