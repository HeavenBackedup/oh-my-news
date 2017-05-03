package com.oh.my.news.model.vo.myHomePage;

/**
 * Created by fanfan on 2017/4/19.
 */
public class User {
    private int userId;
    private String name;
    private String userImgSrc;

    public User(int userId, String name, String userImgSrc) {
        this.userId = userId;
        this.name = name;
        this.userImgSrc = userImgSrc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserImgSrc() {
        return userImgSrc;
    }

    public void setUserImgSrc(String userImgSrc) {
        this.userImgSrc = userImgSrc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return userImgSrc != null ? userImgSrc.equals(user.userImgSrc) : user.userImgSrc == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userImgSrc != null ? userImgSrc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", userImgSrc='" + userImgSrc + '\'' +
                '}';
    }


}
