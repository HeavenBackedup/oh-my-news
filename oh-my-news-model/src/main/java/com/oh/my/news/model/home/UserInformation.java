package com.oh.my.news.model.home;

import java.util.Date;

/**
 * Created by fanfan on 2017/4/17.
 */
public class UserInformation {
    private String avatarPath;
    private String nickName;
    private String signature;
    private String announcement;
    private int followers;
    private int fans;
    private String date;

    public UserInformation(String avatarPath, String nickName, String signature, String announcement, int followers, int fans, String date) {
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
        int result = avatarPath.hashCode();
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
                "avatarPath='" + avatarPath + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", announcement='" + announcement + '\'' +
                ", followers=" + followers +
                ", fans=" + fans +
                ", date='" + date + '\'' +
                '}';
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //    public UserInformation(String avatarPath, String nickName, String signature, String announcement) {
//        this.avatarPath = avatarPath;
//        this.nickName = nickName;
//        this.signature = signature;
//        this.announcement = announcement;
//    }
//
    public UserInformation() {
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserInformation that = (UserInformation) o;
//
//        if (avatarPath != null ? !avatarPath.equals(that.avatarPath) : that.avatarPath != null) return false;
//        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
//        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
//        return announcement != null ? announcement.equals(that.announcement) : that.announcement == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = avatarPath != null ? avatarPath.hashCode() : 0;
//        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
//        result = 31 * result + (signature != null ? signature.hashCode() : 0);
//        result = 31 * result + (announcement != null ? announcement.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String
//    toString() {
//        return "UserInformation{" +
//                "avatarPath='" + avatarPath + '\'' +
//                ", nickName='" + nickName + '\'' +
//                ", signature='" + signature + '\'' +
//                ", announcement='" + announcement + '\'' +
//                '}';
//    }
//
//    public String getAvatarPath() {
//        return avatarPath;
//    }
//
//    public void setAvatarPath(String avatarPath) {
//        this.avatarPath = avatarPath;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public String getSignature() {
//        return signature;
//    }
//
//    public void setSignature(String signature) {
//        this.signature = signature;
//    }
//
//    public String getAnnouncement() {
//        return announcement;
//    }
//
//    public void setAnnouncement(String announcement) {
//        this.announcement = announcement;
//    }
}
