package com.qf.userInfo.controller;

import com.alibaba.fastjson.JSON;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    public String addUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.addUserInfo(userInfo)?"true":"false";
    }

    @RequestMapping(value = "checkRegisterBy",method = RequestMethod.POST)
    public String checkRegisterBy(@RequestBody UserInfo userInfo){
        return userInfoService.checkRegisterBy(userInfo)==0?"true":"false";
    }

    @RequestMapping(value = "checkUserInfoIdBy",method = RequestMethod.POST)
    public Object checkUserInfoIdBy(@RequestBody UserInfo userInfo){
        return userInfoService.selectUserInfoIdBy(userInfo);
    }
}
