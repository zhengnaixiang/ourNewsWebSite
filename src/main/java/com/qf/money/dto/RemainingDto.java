package com.qf.money.dto;

import io.swagger.annotations.ApiModelProperty;

public class RemainingDto {
    private Integer moneyId;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "1代表收益0代表支出")
    private Boolean state;
    @ApiModelProperty(value = "收益/支出的额度")
    private Integer amount;
    @ApiModelProperty(value = "收益/支出日期")
    private Integer operationDate;

    public RemainingDto() {
    }

    public RemainingDto(Integer moneyId, Integer userId, Boolean state, Integer amount, Integer operationDate) {
        this.moneyId = moneyId;
        this.userId = userId;
        this.state = state;
        this.amount = amount;
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "RemainingDto{" +
                "moneyId=" + moneyId +
                ", userId=" + userId +
                ", state=" + state +
                ", amount=" + amount +
                ", operationDate=" + operationDate +
                '}';
    }

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Integer operationDate) {
        this.operationDate = operationDate;
    }
}
