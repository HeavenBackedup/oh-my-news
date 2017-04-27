package com.oh.my.news.model.vo;

/**
 * Created by yanyue on 2017/4/24.
 */
public class ConcernUser {
    Integer  id;
    String username;
    String avatar;
    String address;
    String signature;

    public ConcernUser() {
    }

    public ConcernUser(Integer id, String username, String avatar, String address, String signature) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.address = address;
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
