package com.qf.userInfo.controller;

import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注册验证，检查用户是否已被注册
     * sql查询自动忽略权限1即游客记录
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
//        userInfo.setUser_power(2);//2为普通注册会员
        return userInfoService.addUserInfo(userInfo)?"true":"false";
    }

    /**
     * 激活用户
     * @param user_id
     * @param key
     * @return
     */
    @RequestMapping(value = "activation",method = RequestMethod.GET)
    public String ToActivation(@RequestParam int user_id, int key){
        return userInfoService.ToActivation(user_id,key)?"true":"false";
    }

    /**
     * 登录验证
     * @param userInfo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "loginTo",method = RequestMethod.POST)
    public String loginTo(@RequestBody UserInfo userInfo, HttpSession httpSession){
        userInfo = userInfoService.checklogin(userInfo);
        if (userInfo != null && userInfo.getUser_power()>1) {
            httpSession.setAttribute("userInfo",userInfo);
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 客户端要求从session获取userInfo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "giveStatus")
    public Object giveStatus(HttpSession httpSession){
        Object userInfo = httpSession.getAttribute("userInfo");
        return userInfo != null ? userInfo : "false";
    }

    /**
     * 获取用户权限
     * @param username
     * @return
     */
    @RequestMapping(value = "getUserPower",method = RequestMethod.GET)
    public int getUserPower(@RequestParam String username){
        return userInfoService.getUserPower(username);
    }

    /**
     * 获取用户id
     * @param username
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "getUserId",method = RequestMethod.GET)
    public int getUserId(@RequestParam String username, HttpSession httpSession){
        int user_id = userInfoService.getUserId(username);
        if (user_id>0) {
            httpSession.setAttribute("userInfo",userInfoService.selectUserInfoByName(username));
        }
        return user_id;
    }
}
