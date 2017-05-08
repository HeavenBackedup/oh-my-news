package com.oh.my.news.model.dto;

/**
 * Created by shj on 2017/5/3.
 */
public class ArticleSnapshot {
    private int id;
    private String topic;

    public ArticleSnapshot(int id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public ArticleSnapshot() {
    }
    @Override
    public String toString() {
        return "ArticleSnapshot{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleSnapshot that = (ArticleSnapshot) o;

        if (id != that.id) return false;
        return topic != null ? topic.equals(that.topic) : that.topic == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
