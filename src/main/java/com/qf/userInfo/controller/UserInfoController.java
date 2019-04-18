package com.qf.userInfo.controller;

import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注册游客账号
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "guessRegister",method = RequestMethod.POST)
    public String addUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setUser_power(1);//1为游客账号
        return userInfoService.addUserInfo(userInfo)?"true":"false";
    }

    /**
     * 注册验证，检查用户是否已被注册
     * 权限1即游客记录sql自动忽略
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "checkRegisterBy",method = RequestMethod.POST)
    public String checkRegisterBy(@RequestBody UserInfo userInfo){
        return userInfoService.checkRegisterBy(userInfo)==0?"true":"false";
    }

    /**
     * 注册普通用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@RequestBody UserInfo userInfo){
        userInfo.setUser_power(2);//2为普通注册会员
        return userInfoService.addUserInfo(userInfo)?"true":"false";
    }

    /**
     * 登录验证
     * @param userInfo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "loginTo",method = RequestMethod.POST)
    public String login(@RequestBody UserInfo userInfo, HttpSession httpSession){
        userInfo = userInfoService.checklogin(userInfo);
        if (userInfo != null && userInfo.getUser_power()>1) {
            httpSession.setAttribute("userInfo",userInfo);
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 获取用户权限
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "getUserPower",method = RequestMethod.POST)
    public int getUserPower(@RequestBody UserInfo userInfo){
        return userInfoService.getUserPower(userInfo);
    }

    /**
     * 获取用户id
     * @param userInfo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "getUserId",method = RequestMethod.POST)
    public int getUserId(@RequestBody UserInfo userInfo, HttpSession httpSession){
        int user_id = userInfoService.getUserId(userInfo);
        userInfo.setUser_id(user_id);
        httpSession.setAttribute("userInfo",userInfo);
        return user_id;
    }
}
