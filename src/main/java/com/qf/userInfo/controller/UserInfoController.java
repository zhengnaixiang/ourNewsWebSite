package com.qf.userInfo.controller;

import com.qf.userInfo.dto.UserInfoDto;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping(value = "getFansAndFocus", method = RequestMethod.POST)
    public UserInfoDto getFansAndFocus(@RequestParam int user_id) {
        UserInfoDto focusAndFans = userInfoService.getFocusAndFans(user_id);
        return focusAndFans;
    }

    @RequestMapping(value = "removeFollow",method = RequestMethod.POST)
    public String removeFollow(@RequestParam int from_user_id,@RequestParam int to_user_id){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("from_user_id", from_user_id);
        map.put("to_user_id", to_user_id);
        Boolean i = userInfoService.removeFollow(map)>0;
        return i.toString();
    }

    @RequestMapping(value = "follow",method = RequestMethod.POST)
    public String follow(@RequestParam int from_user_id,@RequestParam int to_user_id){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("from_user_id", from_user_id);
        map.put("to_user_id", to_user_id);
        Boolean i = userInfoService.follow(map)>0;
        return i.toString();
    }
}
