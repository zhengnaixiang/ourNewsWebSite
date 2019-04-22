package com.qf.userInfo.mapper;

import com.qf.userInfo.dto.UserInfoDto;
import com.qf.userInfo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    int checkRegisterBy(UserInfo userInfo);
    int addUserInfo(UserInfo userInfo);
    List<UserInfo> selectUserInfoBy(UserInfo userInfo);
    UserInfo checklogin(UserInfo userInfo);
    UserInfoDto getFocus(int user_id);
    UserInfoDto getFans(int user_id);
    int removeFollow(Map map);
    int follow(Map map);
}
