package com.qf.money.controller;

import com.github.pagehelper.PageInfo;
import com.qf.money.dto.UserMoneyDto;
import com.qf.money.dto.UserMoneyListDto;
import com.qf.money.service.MoneyService;
import com.qf.money.vo.RemainingVo;
import com.qf.money.vo.UserMoneyVo;
import com.qf.personalInformation.tools.ValidatorCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "money模块")
@Controller
@RequestMapping(value = "/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @ApiOperation(value = "用户余额的增减",notes = "用户余额")
    @ResponseBody
    @RequestMapping(value = "/remainingMoney",method = RequestMethod.POST)
    public Integer remainingMoney(@RequestBody RemainingVo remainingVo){

        Integer num = remainingVo.getAmount();
        Integer state = remainingVo.getState();
        Integer userId = remainingVo.getUserId();
        Integer integer = moneyService.remainingMoney(remainingVo);
        moneyService.editUserInfo(num,state,userId);
        return integer;
    }

    @ApiOperation(value = "用户收支的分页信息",notes = "用户收支的分页模糊查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    // @ResponseBody封包，@RequestBody 解包
    public UserMoneyListDto<UserMoneyDto> getReceiveList
            (HttpServletRequest request, @Valid @RequestBody UserMoneyVo userMoneyVo) {
        System.out.println(userMoneyVo);
        //service返回的数据集
        PageInfo<UserMoneyDto> list = moneyService.pageFuzzyselect(userMoneyVo);



        //属性拷贝，返回为给前端的回应
        List<UserMoneyDto> data = new ArrayList<UserMoneyDto>();
        if (list.getList() != null) {
            for (UserMoneyDto tbNewPaperDto : list.getList()) {
                UserMoneyDto bean = new UserMoneyDto();

                String time = tbNewPaperDto.getOperationDate().toString();
                tbNewPaperDto.setTime(time);
                System.out.println(time);

                try {
                    BeanUtils.copyProperties(tbNewPaperDto, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }
        //4.2 接口返回参数，数据库返回属性的类型，data为返回参数实体中的泛型那个
        UserMoneyListDto<UserMoneyDto> userMoneyListDto = new UserMoneyListDto(data);

        //4.3 完善newPaperDto其他参数
        userMoneyListDto.setPageNum(userMoneyVo.getPageNum());//当前页
        userMoneyListDto.setPageSize(userMoneyVo.getPageSize());//分页数
        userMoneyListDto.setTotalRecord(list.getTotal());  //总页数，返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647

        //(总记录数+分页数-1)/分页数
        long totalPage = (userMoneyListDto.getTotalRecord() + userMoneyVo.getPageSize() - 1) / userMoneyVo.getPageSize();
        userMoneyListDto.setTotalPage(totalPage);
        System.out.println(":" + userMoneyListDto);
        /*System.out.println(newPaperVo);*/
        return userMoneyListDto;
    }
}
