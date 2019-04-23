package com.qf.money.mapper;

import com.qf.money.dto.RemainingDto;
import com.qf.money.dto.UserMoneyDto;
import com.qf.money.vo.RemainingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMoneyMapper {
    /**
     * 往money插入收入/支出的基本信息
     * @param remainingVo
     * @return
     */
    public Integer remainingMoney(RemainingVo remainingVo);

    /**
     * 修改用户余额
     * @param amount
     * @param state
     * @return
     */
    public Integer editUserInfo(@Param("amount") Integer amount,
                                @Param("state") Integer state, @Param("userId") Integer userId);


    /**
     * 用户收支信息分页展示
     * @param orderStr
     * @param searchName
     * @return
     */
    public List<UserMoneyDto> pageFuzzyselect
    (@Param("orderStr") String orderStr,
     @Param("search") String searchName, @Param("userId") Integer userId);
}
