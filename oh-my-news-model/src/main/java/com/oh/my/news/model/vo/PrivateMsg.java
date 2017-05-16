package com.oh.my.news.model.vo;

import java.util.Date;

/**
 * Created by yanyue on 2017/4/23.
 */
public class PrivateMsg {
    private Integer  id;
    private String username;
    private String avatar;
    private String message;
    private Date time;
    private Integer userId;


    public PrivateMsg() {
    }

    public PrivateMsg(Integer id, String username, String avatar, String message, Date time) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.message = message;
        this.time = time;
    }

    public PrivateMsg(Integer id, String username, String avatar, String message, Date time, Integer userId) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.message = message;
        this.time = time;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "PrivateMsg{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateMsg that = (PrivateMsg) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
