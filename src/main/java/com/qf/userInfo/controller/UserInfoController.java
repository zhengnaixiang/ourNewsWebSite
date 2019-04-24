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
