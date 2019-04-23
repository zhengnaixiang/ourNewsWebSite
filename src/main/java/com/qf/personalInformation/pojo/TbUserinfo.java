package com.qf.personalInformation.pojo;

import javax.persistence.*;

@Table(name = "userinfo")
public class TbUserinfo {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_tel")
    private String userTel;

    /**
     * 用户别名(作者名)
     */
    @Column(name = "user_alias")
    private String userAlias;

    @Column(name = "user_imageUrl")
    private String userImageurl;

    private String username;

    private String password;

    /**
     * 权限等级
     */
    @Column(name = "user_power")
    private Integer userPower;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户别名(作者名)
     *
     * @return user_alias - 用户别名(作者名)
     */
    public String getUserAlias() {
        return userAlias;
    }

    /**
     * 设置用户别名(作者名)
     *
     * @param userAlias 用户别名(作者名)
     */
    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias == null ? null : userAlias.trim();
    }

    @Override
    public String toString() {
        return "TbUserinfo{" +
                "userId=" + userId +
                ", userTel='" + userTel + '\'' +
                ", userAlias='" + userAlias + '\'' +
                ", userImageurl='" + userImageurl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userPower=" + userPower +
                '}';
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * @return user_imageUrl
     */
    public String getUserImageurl() {
        return userImageurl;
    }

    /**
     * @param userImageurl
     */
    public void setUserImageurl(String userImageurl) {
        this.userImageurl = userImageurl == null ? null : userImageurl.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取权限等级
     *
     * @return user_power - 权限等级
     */
    public Integer getUserPower() {
        return userPower;
    }

    /**
     * 设置权限等级
     *
     * @param userPower 权限等级
     */
    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }
}
