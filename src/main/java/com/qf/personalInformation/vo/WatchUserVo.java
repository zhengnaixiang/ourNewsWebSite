package com.qf.personalInformation.vo;

import io.swagger.annotations.ApiModelProperty;

public class WatchUserVo {
    @ApiModelProperty("用户的ID")
    private Integer userId;

    public WatchUserVo() {
    }

    public WatchUserVo(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WatchUserVo{" +
                "userId=" + userId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
