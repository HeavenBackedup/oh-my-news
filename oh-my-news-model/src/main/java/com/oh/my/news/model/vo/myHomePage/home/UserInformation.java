package com.oh.my.news.model.vo.myHomePage.home;

import java.util.Date;

/**
 * Created by fanfan on 2017/4/17.
 */
public class UserInformation {
    private int usersId;
    private String avatarPath;
    private String nickName;
    private String signature;
    private String announcement;
    private int followers;
    private int fans;
    private Date date;

    public UserInformation(int usersId, String avatarPath, String nickName, String signature, String announcement, int followers, int fans, Date date) {
        this.usersId = usersId;
        this.avatarPath = avatarPath;
        this.nickName = nickName;
        this.signature = signature;
        this.announcement = announcement;
        this.followers = followers;
        this.fans = fans;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInformation that = (UserInformation) o;

        if (usersId != that.usersId) return false;
        if (followers != that.followers) return false;
        if (fans != that.fans) return false;
        if (!avatarPath.equals(that.avatarPath)) return false;
        if (!nickName.equals(that.nickName)) return false;
        if (!signature.equals(that.signature)) return false;
        if (!announcement.equals(that.announcement)) return false;
        return date.equals(that.date);

    }

    @Override
    public int hashCode() {
        int result = usersId;
        result = 31 * result + avatarPath.hashCode();
        result = 31 * result + nickName.hashCode();
        result = 31 * result + signature.hashCode();
        result = 31 * result + announcement.hashCode();
        result = 31 * result + followers;
        result = 31 * result + fans;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "usersId=" + usersId +
                ", avatarPath='" + avatarPath + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", announcement='" + announcement + '\'' +
                ", followers=" + followers +
                ", fans=" + fans +
                ", date=" + date +
                '}';
    }


    public UserInformation() {
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}