package com.qf.personalInformation.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class WatchUserDto {
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @Length(min = 2,max = 12,message = "用户别名的长度要在2到12之间")
    @ApiModelProperty(value = "用户别名(作者名)")
    private String userAlias;
    @Pattern(regexp = "[1234567890]{11}",message = "手机号码格式唔正确")
    @ApiModelProperty(value = "电话号码")
    private String userTel;
    @ApiModelProperty(value = "用户头像")
    private String userImageurl;
    @ApiModelProperty(value = "用户名")
    @Length(min = 2,max = 18,message = "用户名的长度要在2到18之间")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "用户权限")
    private Integer userPower;

    public WatchUserDto() {
    }

    public WatchUserDto(Integer userId, String userAlias, String userTel, String userImageurl, String username, String password, Integer userPower) {
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
