package com.oh.my.news.model.po;

import java.util.Date;

/**
 * Created by llf on 2017/5/6.
 */
public class UserWrite {
    private int id;
    private int isDelete;
    private String username;
    private String password;
    private String email;
    private String address;
    private Integer media_id;
    private String signature;
    private String announcement;
    private Date date;
    private String nickname;
    private int isLimit;
    public UserWrite(int id, int isDelete, String username, String password, String email, String address,  String signature, String announcement, Date date, String nickname, int isLimit) {
        this.id = id;
        this.isDelete = isDelete;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.signature = signature;
        this.announcement = announcement;
        this.date = date;
        this.nickname = nickname;
        this.isLimit = isLimit;
    }

    public UserWrite() {
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
                ", media_id='" + media_id + '\'' +
                ", signature='" + signature + '\'' +
                ", announcement='" + announcement + '\'' +
                ", date=" + date +
                ", nickname='" + nickname + '\'' +
                ", isLimit=" + isLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserWrite user = (UserWrite) o;

        if (id != user.id) return false;
        if (isDelete != user.isDelete) return false;
        if (isLimit != user.isLimit) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (media_id != null ? !media_id.equals(user.media_id) : user.media_id != null) return false;
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
        result = 31 * result + (media_id != null ? media_id.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (announcement != null ? announcement.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + isLimit;
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


    public Integer getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Integer media_id) {
        this.media_id = media_id;
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

    public int getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(int isLimit) {
        this.isLimit = isLimit;
    }
}
