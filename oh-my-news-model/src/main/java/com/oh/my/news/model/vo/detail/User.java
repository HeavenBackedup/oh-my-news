package com.oh.my.news.model.vo.detail;

/**
 * Created by fanfan on 2017/4/19.
 */
public class User {////给前端显示的用户信息
    private int userId;
    private String name;
    private String userImgSrc;
    private float totalMoney;//新加的


    public User() {
    }

    public User(int userId, String name, String userImgSrc, float totalMoney) {
        this.userId = userId;
        this.name = name;
        this.userImgSrc = userImgSrc;
        this.totalMoney = totalMoney;
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

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", userImgSrc='" + userImgSrc + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
