package com.oh.my.news.model.vo.myHomePage.home;

/**
 * Created by fanfan on 2017/4/23.
 */
public class OthersInfomation {

    private int userId;
    private String avatarPath;
    private String nickName;
    private String signature;

    public OthersInfomation(int userId, String avatarPath, String nickName, String signature) {
        this.userId = userId;
        this.avatarPath = avatarPath;
        this.nickName = nickName;
        this.signature = signature;
    }

    public OthersInfomation() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OthersInfomation that = (OthersInfomation) o;

        if (userId != that.userId) return false;
        if (!avatarPath.equals(that.avatarPath)) return false;
        if (!nickName.equals(that.nickName)) return false;
        return signature.equals(that.signature);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + avatarPath.hashCode();
        result = 31 * result + nickName.hashCode();
        result = 31 * result + signature.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OthersInfomation{" +
                "userId=" + userId +
                ", avatarPath='" + avatarPath + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
