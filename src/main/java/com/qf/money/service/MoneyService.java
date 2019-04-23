package com.qf.money.service;


import com.github.pagehelper.PageInfo;
import com.qf.money.dto.RemainingDto;
import com.qf.money.dto.UserMoneyDto;
import com.qf.money.vo.RemainingVo;
import com.qf.money.vo.UserMoneyVo;

public interface MoneyService {
    public Integer remainingMoney(RemainingVo remainingVo);

    public Integer editUserInfo(Integer amount, Integer state, Integer userId);

    public PageInfo<UserMoneyDto> pageFuzzyselect(UserMoneyVo userMoneyVo);
}
