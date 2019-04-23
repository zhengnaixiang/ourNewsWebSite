package com.qf.money.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "money")
public class TbMoney {
    @Id
    @Column(name = "money_id")
    private Integer moneyId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 1代表收益0代表支出
     */
    private Boolean state;

    /**
     * 收益/支出的额度
     */
    private Integer amount;

    /**
     * 收益/支出日期
     */
    @Column(name = "operation_date")
    private Date operationDate;

    /**
     * @return money_id
     */
    public Integer getMoneyId() {
        return moneyId;
    }

    /**
     * @param moneyId
     */
    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

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
     * 获取1代表收益0代表支出
     *
     * @return state - 1代表收益0代表支出
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置1代表收益0代表支出
     *
     * @param state 1代表收益0代表支出
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取收益/支出的额度
     *
     * @return amount - 收益/支出的额度
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置收益/支出的额度
     *
     * @param amount 收益/支出的额度
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取收益/支出日期
     *
     * @return operation_date - 收益/支出日期
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * 设置收益/支出日期
     *
     * @param operationDate 收益/支出日期
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}
