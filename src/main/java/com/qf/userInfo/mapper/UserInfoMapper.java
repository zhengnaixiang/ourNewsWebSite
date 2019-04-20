package com.qf.userInfo.mapper;

import com.qf.userInfo.pojo.Activation;
import com.qf.userInfo.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int checkRegisterBy(UserInfo userInfo);

    /**
     * 为防止重复用户，执行add前必须保证用户不存在！
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);

//    List<UserInfo> selectUserInfoBy(UserInfo userInfo);

    UserInfo checklogin(UserInfo userInfo);


    /**
     * 根据username获取userInfo对象
     * @param username
     * @return
     */
    UserInfo selectUserInfoByName(String username);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 登记待激活记录
     * @param activation
     * @return
     */
    int addActivation(Activation activation);

    /**
     * 查找待激活数据库表是否有该记录
     * （待优化）加入时间范围限制，防止暴力抢注
     * @param user_id
     * @param key
     * @return
     */
    int checkActivation(@Param("user_id")int user_id, @Param("activation_key")int key);

    /**
     * 清空用户的待激活记录
     * @param user_id
     * @return
     */
    int deleteActivationByUserId(int user_id);
}
