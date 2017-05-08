package com.oh.my.news.model.dto;
import java.util.Date;

/**
 * Created by shj on 2017/5/2.
 */
public class PrivateMessage {
    private int id;
    private String sourceUsername;
    private String imageUrl;
    private String content;
    private Date date;


    public PrivateMessage(int id, String sourceUsername, String imageUrl, String content, Date date) {
        this.id = id;
        this.sourceUsername = sourceUsername;
        this.imageUrl = imageUrl;
        this.content = content;
        this.date = date;
    }

    public PrivateMessage() {
    }


    @Override
    public String toString() {
        return "PrivateMessage{" +
                "id=" + id +
                ", sourceUsername='" + sourceUsername + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateMessage that = (PrivateMessage) o;

        if (id != that.id) return false;
        if (sourceUsername != null ? !sourceUsername.equals(that.sourceUsername) : that.sourceUsername != null)
            return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sourceUsername != null ? sourceUsername.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceUsername() {
        return sourceUsername;
    }

    public void setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
