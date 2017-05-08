package com.oh.my.news.model.po;

/**
 * Created by Administrator on 2017/5/7.
 */
public class PrivateMessagePo {
    private int id;
    private int sourceUserId;
    private int targetUserId;
    private String content;

    public PrivateMessagePo(int id, int sourceId, int targetId, String content) {
        this.id = id;
        this.sourceUserId = sourceId;
        this.targetUserId = targetId;
        this.content = content;
    }
    public PrivateMessagePo(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceUserId;
    }

    public void setSourceId(int sourceId) {
        this.sourceUserId = sourceId;
    }

    public int getTargetId() {
        return targetUserId;
    }

    public void setTargetId(int targetId) {
        this.targetUserId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateMessagePo that = (PrivateMessagePo) o;

        if (id != that.id) return false;
        if (sourceUserId != that.sourceUserId) return false;
        if (targetUserId != that.targetUserId) return false;
        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sourceUserId;
        result = 31 * result + targetUserId;
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PrivateMessagePo{" +
                "id=" + id +
                ", sourceId=" + sourceUserId +
                ", targetId=" + targetUserId +
                ", content='" + content + '\'' +
                '}';
    }
}
