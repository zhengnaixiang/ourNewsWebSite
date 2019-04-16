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
     * 找到对应的用户信息(精确查找)
     * @param userInfo
     * @return
     */
    List<UserInfo> selectUserInfoIdBy(UserInfo userInfo);
}
