package com.qf.personalInformation.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

public class WatchsUserDto {
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "用户别名(作者名)")
    private String userAlias;
    @ApiModelProperty(value = "电话号码")
    private String userTel;
    @ApiModelProperty(value = "用户头像")
    private String userImageurl;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    @Length(min = 2,max = 12,message = "密码的长度要在2到12之间")
    private String password;
    @ApiModelProperty(value = "用户权限")
    private Integer userPower;

    public WatchsUserDto() {
    }

    public WatchsUserDto(Integer userId, String userAlias, String userTel, String userImageurl, String username, String password, Integer userPower) {
        this.userId = userId;
        this.userAlias = userAlias;
        this.userTel = userTel;
        this.userImageurl = userImageurl;
        this.username = username;
        this.password = password;
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        return "WatchUserDto{" +
                "userId=" + userId +
                ", userAlias='" + userAlias + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userImageurl='" + userImageurl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userPower=" + userPower +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserImageurl() {
        return userImageurl;
    }

    public void setUserImageurl(String userImageurl) {
        this.userImageurl = userImageurl;
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

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }
}
