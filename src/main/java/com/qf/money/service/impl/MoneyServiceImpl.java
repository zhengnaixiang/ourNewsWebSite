package com.qf.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.qf.money.dto.UserMoneyDto;
import com.qf.money.mapper.TbMoneyMapper;
import com.qf.money.service.MoneyService;
import com.qf.money.vo.RemainingVo;
import com.qf.money.vo.UserMoneyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private TbMoneyMapper tbMoneyMapper;


    public Integer remainingMoney(RemainingVo remainingVo) {
        return tbMoneyMapper.remainingMoney(remainingVo);
    }


    public Integer editUserInfo(Integer amount, Integer state,Integer userId) {
        return tbMoneyMapper.editUserInfo(amount,state,userId);
    }


    public PageInfo<UserMoneyDto> pageFuzzyselect(UserMoneyVo userMoneyVo) {
        PageHelper.startPage(userMoneyVo.getPageNum(),userMoneyVo.getPageSize());

        /*用mybatis分页插件来实现自动分页*/
        int start = userMoneyVo.getPageNum();
        int pageSize = userMoneyVo.getPageSize();
        PageHelper.startPage(start,pageSize);

//        List<ReceiveTargetPo> data = tbReceiveTargetMapper.pageFuzzyselect();

        /*4.7.5添加orderStr,排序*/
        String orderStr = getOrderStr(userMoneyVo);

        String searchName = userMoneyVo.getSearch();
        Integer userId = userMoneyVo.getUserId();
        List<UserMoneyDto> data = tbMoneyMapper.pageFuzzyselect(orderStr,searchName,userId);

        return new PageInfo<UserMoneyDto>(data);
    }

    private String getOrderStr(UserMoneyVo userMoneyVo){
        StringBuffer stringBuffer = new StringBuffer();
        /* 从data.html查columns: [
                  { "data": "np_id" },
                  { "data": "np_title" },
                  { "data": "user_alias" },
                  { "data": "np_date" },
                  { "data": "class_name" },
                  { "data": "np_likes" },
                  { "data": "np_comment"" }
        ]*/

        if(!StringUtil.isEmpty(userMoneyVo.getOrder())) {
            String strs[] = {"userAlias","state","amount","operationDate","haveMoney"};
            stringBuffer.append(" order by "+strs[Integer.parseInt(userMoneyVo.getOrder())]+" " + userMoneyVo.getDir());
        }
        return stringBuffer.toString();
    }
}
