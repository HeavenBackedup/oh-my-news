package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.User;

import java.util.Date;

/**
 * Created by shj on 2017/5/1.
 */
public class UserDto extends User {
    private int followers;
    private int fans;


    public UserDto(int id, int isDelete, String username, String password, String email, String address, int mediaId, String signature, String announcement, Date date, String nickname, int followers, int fans) {
        super(id, isDelete, username, password, email, address, mediaId, signature, announcement, date, nickname);
        this.followers = followers;
        this.fans = fans;
    }

    public UserDto(int followers, int fans) {
        this.followers = followers;
        this.fans = fans;
    }

    public UserDto() {
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "followers=" + followers +
                ", fans=" + fans +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserDto userDto = (UserDto) o;

        if (followers != userDto.followers) return false;
        return fans == userDto.fans;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + followers;
        result = 31 * result + fans;
        return result;
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
}
