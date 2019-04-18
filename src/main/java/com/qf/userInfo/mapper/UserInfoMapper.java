package com.qf.userInfo.mapper;

import com.qf.userInfo.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int checkRegisterBy(UserInfo userInfo);
    int addUserInfo(UserInfo userInfo);
    List<UserInfo> selectUserInfoIdBy(UserInfo userInfo);
    UserInfo checkSingIn(UserInfo userInfo);
}
