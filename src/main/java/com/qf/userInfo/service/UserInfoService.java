package com.qf.userInfo.service;

import com.qf.userInfo.pojo.UserInfo;

import java.util.List;

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
    UserInfo checkSingIn(UserInfo userInfo);

    /**
     * 获取用户id
     * @param userInfo
     * @return
     */
    int getUserId(UserInfo userInfo);

    /**
     * 获取用户权限
     * 用户不存在时新建并返回游客用户权限 1，创建失败返回 -1
     * @param userInfo
     * @return
     */
    int getUserPower(UserInfo userInfo);
}
