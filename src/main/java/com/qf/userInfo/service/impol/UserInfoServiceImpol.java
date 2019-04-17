package com.qf.userInfo.service.impol;

import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpol implements UserInfoService {

   /* @Autowired
    private UserInfoMapper userInfoMapper;*/

    public int checkRegisterBy(UserInfo userInfo) {
      /*  return userInfoMapper.checkRegisterBy(userInfo);*/
        return 0;
    }

    public boolean addUserInfo(UserInfo userInfo) {
      /*  return userInfoMapper.addUserInfo(userInfo)>0;*/
        return false;
    }

    public List<UserInfo> selectUserInfoIdBy(UserInfo userInfo) {
       /* return userInfoMapper.selectUserInfoIdBy(userInfo);*/
        return null;
    }
}
