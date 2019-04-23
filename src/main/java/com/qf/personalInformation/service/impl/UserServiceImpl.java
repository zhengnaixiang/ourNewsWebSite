package com.qf.personalInformation.service.impl;

import com.qf.personalInformation.dto.WatchUserDto;
import com.qf.personalInformation.mapper.TbUserinfoMapper;
import com.qf.personalInformation.pojo.TbUserinfo;
import com.qf.personalInformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserinfoMapper tbUserinfoMapper;


    public Integer editUser(WatchUserDto watchUserDto) {
        return tbUserinfoMapper.editUser(watchUserDto);
    }


    public List<WatchUserDto> watchUser(Integer userId) {
        System.out.println(":!11");
        return tbUserinfoMapper.watchUser(userId);
    }


    public Integer editUserImg(String img,Integer userId) {
        return tbUserinfoMapper.editUserImg(img,userId);
    }


    public Integer watchPassword(String password,Integer userId) {
        String s = tbUserinfoMapper.watchPassword(userId);
        if (password.equals(s)){
            return 1;
        }
        return 0;
    }


    public Integer editPassword(String password, Integer userId) {
        return tbUserinfoMapper.editPassword(password,userId);
    }
}
