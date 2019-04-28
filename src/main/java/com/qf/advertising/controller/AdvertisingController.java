package com.qf.advertising.controller;

import com.qf.advertising.dto.SlidingDto;
import com.qf.advertising.pojo.TbAdvertising;
import com.qf.advertising.service.AdvertisingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "广告模块")
@Controller
@RequestMapping(value = "/advertising")
public class AdvertisingController {
    @Autowired
    private AdvertisingService advertisingService;

    @ApiOperation(value = "加载普通广告",notes = "普通广告")
    @ResponseBody
    @RequestMapping(value = "/ordinary",method = RequestMethod.POST)
    public TbAdvertising ordinary(){
        TbAdvertising ordinary = advertisingService.ordinary();
        return ordinary;
    }


    @ApiOperation(value = "加载滑动广告",notes = "滑动广告")
    @ResponseBody
    @RequestMapping(value = "/sliding",method = RequestMethod.POST)
    public SlidingDto sliding(){
        List<TbAdvertising> sliding = advertisingService.sliding();
        SlidingDto slidingDto = new SlidingDto();
        slidingDto.setList(sliding);
//        System.out.println(":::" + slidingDto);
        return slidingDto;
    }
}
