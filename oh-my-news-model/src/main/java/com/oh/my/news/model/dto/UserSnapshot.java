package com.oh.my.news.model.dto;

/**
 * Created by shj on 2017/5/1.
 */
public class UserSnapshot {
    private int id;
    private String imageUrl;
    private String nickname;
    private String signature;

    public UserSnapshot(int id, String imageUrl, String nickname, String signature) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.nickname = nickname;
        this.signature = signature;
    }

    public UserSnapshot() {
    }

    @Override
    public String toString() {
        return "UserSnapshot{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSnapshot that = (UserSnapshot) o;

        if (id != that.id) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        return signature != null ? signature.equals(that.signature) : that.signature == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
