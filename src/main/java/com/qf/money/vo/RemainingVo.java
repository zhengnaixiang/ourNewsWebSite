package com.qf.money.vo;

import io.swagger.annotations.ApiModelProperty;

public class RemainingVo {
    @ApiModelProperty("用户的id")
    private Integer userId;
    @ApiModelProperty("用户余额增/减的状态(1增0减)")
    private Integer state;
    @ApiModelProperty("用户余额增/减的额度")
    private Integer amount;

    public RemainingVo() {
    }

    public RemainingVo(Integer userId, Integer state, Integer amount) {
        this.userId = userId;
        this.state = state;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RemainingVo{" +
                "userId=" + userId +
                ", state=" + state +
                ", amount=" + amount +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
