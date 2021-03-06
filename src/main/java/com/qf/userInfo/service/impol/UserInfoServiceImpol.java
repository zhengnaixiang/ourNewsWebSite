package com.qf.userInfo.service.impol;

import com.qf.userInfo.dto.UserInfoDto;
import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.Activation;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import com.qf.userInfo.utils.EmailSendUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class UserInfoServiceImpol implements UserInfoService {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    @Autowired
    private EmailSendUtils emailSendUtils;

//    private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
//    private static UserInfoMapper userInfoMapper=context .getBean(UserInfoMapper.class);

    public int checkRegisterBy(UserInfo userInfo) {
        return userInfoMapper.checkRegisterBy(userInfo);
    }

    public boolean addUserInfo(UserInfo userInfo) {
        // 1. 借用权限方法合法创建游客账号
        if (getUserPower(userInfo.getUsername()) == 1) {
            // 2. 获取user_id
            int user_id = userInfoMapper.selectUserInfoByName(userInfo.getUsername()).getUser_id();
            userInfo.setUser_id(user_id);
            userInfo.setUser_power(1);
            System.out.println("更新信息至"+userInfo);
            // 3. 更新用户信息
            if (userInfoMapper.updateUserInfo(userInfo)>0) {
                // 4. 登记待激活信息
                int key = new Random().nextInt(99999999)+1;
                if (userInfoMapper.addActivation(new Activation(user_id,key))>0) {
                    try {
                        String activationUrl = "点击下面连接激活账号：\nhttp://localhost:8080/front_newsWebSite/activation?user_id="+user_id+"&key="+key;
                        emailSendUtils.send("你在新闻网注册的账号点击激活",activationUrl,"460015041@qq.com");
                    } catch (Exception e) {

                    } finally {
                        return true;
                    }
                } else {
                    // ?. 信息更新成功但是激活信息登记失败如何回滚

                }
            }
        }
        return false;
    }

    public UserInfo checklogin(UserInfo userInfo) {
        return userInfoMapper.checklogin(userInfo);
    }


    public int getUserId(String username) {
        return userInfoMapper.selectUserInfoByName(username).getUser_id();
    }

    public UserInfo selectUserInfoByName(String username) {
        return userInfoMapper.selectUserInfoByName(username);
    }

    public int getUserPower(String username) {
        UserInfo userInfo = userInfoMapper.selectUserInfoByName(username);
        if (userInfo == null) {
            //数据库没有该记录，即访客是新游客
            userInfo = new UserInfo();
            userInfo.setUsername(username);
            //创建游客用户
            if (userInfoMapper.addUserInfo(userInfo)>0) {
                userInfo = userInfoMapper.selectUserInfoByName(username);
            } else {
//                System.out.println("创建游客失败");
                return -1;
            }
        }
        return userInfo.getUser_power();
    }

    public boolean ToActivation(int user_id, int key) {
        if (userInfoMapper.checkActivation(user_id,key)>0) {
            // 激活信息正确。更新用户权限至2
            UserInfo uTemp = new UserInfo();
            uTemp.setUser_id(user_id);
            uTemp.setUser_power(2);
            if (userInfoMapper.updateUserInfo(uTemp)>0) {
                // 更新成功，清空激活记录表
                userInfoMapper.deleteActivationByUserId(user_id);
                return true;
            }
        }
        return false;
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
