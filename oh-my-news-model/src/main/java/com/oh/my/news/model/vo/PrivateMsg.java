package com.oh.my.news.model.vo;

/**
 * Created by yanyue on 2017/4/23.
 */
public class PrivateMsg {
    Integer  id;
    String username;
    String avatar;
    String message;
    String time;

    public PrivateMsg() {
    }

    public PrivateMsg(Integer id, String username, String avatar, String message, String time) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.message = message;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
