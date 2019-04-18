package com.qf.userInfo.service.impol;

import com.qf.newsPaper.mapper.NewsMapper;
import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpol implements UserInfoService {

   /* @Autowired
    private UserInfoMapper userInfoMapper;*/
    private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    private static UserInfoMapper userInfoMapper=context .getBean(UserInfoMapper.class);


    public int checkRegisterBy(UserInfo userInfo) {
        return userInfoMapper.checkRegisterBy(userInfo);
    }

    public boolean addUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo)>0;
    }

    public UserInfo checkSingIn(UserInfo userInfo) {
        return userInfoMapper.checkSingIn(userInfo);
    }

    public int getUserId(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoIdBy(userInfo).get(0).getUser_id();
    }


    public int getUserPower(UserInfo userInfo) {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfoIdBy(userInfo);
        if (userInfos == null || userInfos.isEmpty()) {
            //数据库不存在，即访客是新游客
            userInfo.setUser_power(1);
            //创建游客用户
            if (addUserInfo(userInfo)) {
                userInfos = userInfoMapper.selectUserInfoIdBy(userInfo);
            } else {
//                System.out.println("创建游客失败");
                return -1;
            }
        }
        return userInfos.get(0).getUser_power();
    }
    public List<UserInfo> selectUserInfoIdBy(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoIdBy(userInfo);
    }
}
