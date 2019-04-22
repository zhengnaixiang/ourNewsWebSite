package com.qf.userInfo.dto;

import com.qf.userInfo.pojo.UserInfo;

import java.util.List;

public class UserInfoDto {
    int user_id;
    String	user_alias;
    String	user_tel;
    String	user_imageUrl;
    String	username;
    String password;
    int	user_power;
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    List<UserInfo> focus;

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "user_id=" + user_id +
                ", user_alias='" + user_alias + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_imageUrl='" + user_imageUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_power=" + user_power +
                ", num=" + num +
                ", focus=" + focus +
                ", fans=" + fans +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String user_alias) {
        this.user_alias = user_alias;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_imageUrl() {
        return user_imageUrl;
    }

    public void setUser_imageUrl(String user_imageUrl) {
        this.user_imageUrl = user_imageUrl;
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

    public int getUser_power() {
        return user_power;
    }

    public void setUser_power(int user_power) {
        this.user_power = user_power;
    }

    public List<UserInfo> getFocus() {
        return focus;
    }

    public void setFocus(List<UserInfo> focus) {
        this.focus = focus;
    }

    public List<UserInfo> getFans() {
        return fans;
    }

    public void setFans(List<UserInfo> fans) {
        this.fans = fans;
    }

    List<UserInfo> fans;
}
