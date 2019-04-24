package com.qf.personalInformation.service;

import com.qf.personalInformation.dto.WatchUserDto;
import com.qf.personalInformation.pojo.TbUserinfo;

import java.util.List;

public interface UserService {
    public Integer editUser(WatchUserDto watchUserDto);

    public List<WatchUserDto> watchUser(Integer userId);

    public Integer editUserImg(String img, Integer userId);

    public Integer watchPassword(String password, Integer userId);

    public Integer editPassword(String password, Integer userId);
}
