package com.qf.money.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class UserMoneyDto {
    @ApiModelProperty("用户别名(作者名)")
    private String userAlias;
    @ApiModelProperty("收入/支出状态")
    private Integer state;
    @ApiModelProperty("收入/支出数额")
    private Integer amount;
    @ApiModelProperty("收入/支出时间")
    private Date operationDate;
    @ApiModelProperty("余额")
    private Integer haveMoney;
    @ApiModelProperty("时间")
    private String time;

    public UserMoneyDto() {
    }

    public UserMoneyDto(String userAlias, Integer state, Integer amount, Date operationDate, Integer haveMoney, String time) {
        this.userAlias = userAlias;
        this.state = state;
        this.amount = amount;
        this.operationDate = operationDate;
        this.haveMoney = haveMoney;
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserMoneyDto{" +
                "userAlias='" + userAlias + '\'' +
                ", state=" + state +
                ", amount=" + amount +
                ", operationDate=" + operationDate +
                ", haveMoney=" + haveMoney +
                ", time='" + time + '\'' +
                '}';
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
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

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getHaveMoney() {
        return haveMoney;
    }

    public void setHaveMoney(Integer haveMoney) {
        this.haveMoney = haveMoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
