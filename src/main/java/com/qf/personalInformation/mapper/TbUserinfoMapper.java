package com.qf.personalInformation.mapper;

import com.qf.personalInformation.dto.WatchUserDto;
import com.qf.personalInformation.pojo.TbUserinfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbUserinfoMapper {
    /**
     * 修改用户
     * @param watchUserDto
     * @return
     */
    public Integer editUser(WatchUserDto watchUserDto);

    /**
     * 用户信息回显
     * @return
     */
    public List<WatchUserDto> watchUser(@Param("userId") Integer userId);

    /**
     * 修改用户头像
     * @param img
     * @param userId
     * @return
     */
    public Integer editUserImg(@Param("img") String img, @Param("userId") Integer userId);

    /**
     * 查看旧密码是否正确
     * @param userId
     * @return
     */
    public String watchPassword(@Param("userId") Integer userId);


    public Integer editPassword(@Param("password") String password, @Param("userId") Integer userId);
}
