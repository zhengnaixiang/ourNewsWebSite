package com.qf.userInfo.mapper;

import com.qf.userInfo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserInfoMapper {
    int checkRegisterBy(UserInfo userInfo);
    int addUserInfo(UserInfo userInfo);
    List<UserInfo> selectUserInfoBy(UserInfo userInfo);
    UserInfo checklogin(UserInfo userInfo);
}
