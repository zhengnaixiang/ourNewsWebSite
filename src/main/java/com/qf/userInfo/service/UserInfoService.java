package com.qf.userInfo.service;

import com.qf.userInfo.dto.UserInfoDto;
import com.qf.userInfo.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    /**
     * 注册信息是否已存在
     * 返回值0即未注册
     * @param userInfo
     * @return
     */
    int checkRegisterBy(UserInfo userInfo);

    /**
     * 新增用户
     * 返回true即注册成功
     * @param userInfo
     * @return
     */
    boolean addUserInfo(UserInfo userInfo);

    /**
     * 登录验证
     * @param userInfo
     * @return
     */
    UserInfo checklogin(UserInfo userInfo);

    /**
     * 获取用户id
     * @param username
     * @return
     */
    int getUserId(String username);

    /**
     * 获取用户权限
     * 用户不存在时新建并返回游客用户权限 1，创建失败返回 -1
     * @param username
     * @return
     */
    int getUserPower(String username);

    /**
     * 判断用户名是否已存在
     * @param username
     * @return true即存在
     */
    UserInfo selectUserInfoByName(String username);

    /**
     * 根据浏览器get过来的键值对查找数据库
     * 如果有即自动更新该userinfo的power_id为2，即普通会员
     * 并删除数据库对应的待激活记录
     * @param user_id
     * @param key
     * @return
     */
    boolean ToActivation(int user_id, int key);

    UserInfoDto getFocusAndFans(int user_id);

    int removeFollow(Map map);

    int follow(Map map);

}
