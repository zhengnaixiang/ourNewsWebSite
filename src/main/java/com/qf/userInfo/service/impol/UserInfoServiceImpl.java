package com.qf.userInfo.service.impol;

import com.qf.newsPaper.mapper.NewsMapper;
import com.qf.userInfo.dto.UserInfoDto;
import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

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

    public UserInfo checklogin(UserInfo userInfo) {
        return userInfoMapper.checklogin(userInfo);
    }

    public int getUserId(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoBy(userInfo).get(0).getUser_id();
    }


    public int getUserPower(UserInfo userInfo) {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfoBy(userInfo);
        if (userInfos == null || userInfos.isEmpty()) {
            //数据库不存在，即访客是新游客
            userInfo.setUser_power(1);
            //创建游客用户
            if (addUserInfo(userInfo)) {
                userInfos = userInfoMapper.selectUserInfoBy(userInfo);
            } else {
//                System.out.println("创建游客失败");
                return -1;
            }
        }
        return userInfos.get(0).getUser_power();
    }

    public List<UserInfo> selectUserInfoBy(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoBy(userInfo);
    }

    public UserInfoDto getFocusAndFans(int user_id) {
        UserInfoDto userInfoDto = userInfoMapper.getFans(user_id);
        userInfoDto.setFocus(userInfoMapper.getFocus(user_id).getFocus());
        return userInfoDto;
    }

    public int removeFollow(Map map) {
        return userInfoMapper.removeFollow(map);
    }

    public int follow(Map map) {
        return userInfoMapper.follow(map);
    }
}
