package com.oh.my.news.model.vo.myHomePage.home;

/**
 * Created by fanfan on 2017/4/23.
 */
public class OthersInfomation {

    private int userId;
    private String avatarPath;
    private String nickName;
    private String signature;
    private boolean isConcernRel;

    public OthersInfomation(int userId, String avatarPath, String nickName, String signature, boolean isConcernRel) {
        this.userId = userId;
        this.avatarPath = avatarPath;
        this.nickName = nickName;
        this.signature = signature;
        this.isConcernRel = isConcernRel;
    }

    public OthersInfomation() {
    }

    public boolean isConcernRel() {
        return isConcernRel;
    }

    public void setConcernRel(boolean concernRel) {
        isConcernRel = concernRel;
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
        if (isConcernRel != that.isConcernRel) return false;
        if (avatarPath != null ? !avatarPath.equals(that.avatarPath) : that.avatarPath != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        return signature != null ? signature.equals(that.signature) : that.signature == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (avatarPath != null ? avatarPath.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (isConcernRel ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OthersInfomation{" +
                "userId=" + userId +
                ", avatarPath='" + avatarPath + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", isConcernRel=" + isConcernRel +
                '}';
    }
}
