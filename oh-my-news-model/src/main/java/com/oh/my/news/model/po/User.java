package com.oh.my.news.model.po;

import java.util.Date;

/**
 * Created by shj on 2017/5/1.
 */
public class User {
    private int id;
    private int isDelete;
    private String username;
    private String password;
    private String email;
    private String address;
    private int mediaId;
    private String signature;
    private String announcement;
    private Date date;
    private String nickname;


    public User(int id, int isDelete, String username, String password, String email, String address, int mediaId, String signature, String announcement, Date date, String nickname) {
        this.id = id;
        this.isDelete = isDelete;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mediaId = mediaId;
        this.signature = signature;
        this.announcement = announcement;
        this.date = date;
        this.nickname = nickname;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isDelete != user.isDelete) return false;
        if (mediaId != user.mediaId) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (signature != null ? !signature.equals(user.signature) : user.signature != null) return false;
        if (announcement != null ? !announcement.equals(user.announcement) : user.announcement != null) return false;
        if (date != null ? !date.equals(user.date) : user.date != null) return false;
        return nickname != null ? nickname.equals(user.nickname) : user.nickname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + isDelete;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + mediaId;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (announcement != null ? announcement.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mediaId=" + mediaId +
                ", signature='" + signature + '\'' +
                ", announcement='" + announcement + '\'' +
                ", date=" + date +
                ", nickname='" + nickname + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
