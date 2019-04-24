package com.qf.personalInformation.controller;

import com.qf.personalInformation.dto.WatchUserDto;
import com.qf.personalInformation.dto.WatchsUserDto;
import com.qf.personalInformation.service.UserService;
import com.qf.personalInformation.tools.ValidatorCheck;
import com.qf.personalInformation.vo.WatchUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(tags = "用户模块")
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户信息回显",notes = "信息回显")
    @ResponseBody
    @RequestMapping(value = "/watchUser",method = RequestMethod.POST)
    public List<WatchUserDto> watchUser(@RequestBody WatchUserVo watchUserVo){
        System.out.println(watchUserVo);
        List<WatchUserDto> watchUserDtos = userService.watchUser(watchUserVo.getUserId());
        return watchUserDtos;
    }

    @ApiOperation(value = "用户修改",notes = "用户修改")
    @ResponseBody
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public Integer editUser(@Valid @RequestBody WatchUserDto watchUserDto, BindingResult errors){
        // 后台校验分页插件
        ValidatorCheck.checkParameter(errors);

        Integer integer = userService.editUser(watchUserDto);
        return integer;
    }

    @ApiOperation(value = "用户修改密码",notes = "密码修改")
    @ResponseBody
    @RequestMapping(value = "/editPassword",method = RequestMethod.POST)
    public Integer editPassword(@Valid @RequestBody WatchsUserDto watchsUserDto, BindingResult errors){
        // 后台校验分页插件
        ValidatorCheck.checkParameter(errors);

        Integer integer = userService.editPassword(watchsUserDto.getPassword(),watchsUserDto.getUserId());
        return integer;
    }

    @ApiOperation(value = "查看用户旧密码是否正确",notes = "查看旧密码")
    @ResponseBody
    @RequestMapping(value = "/watchPassword",method = RequestMethod.POST)
    public Integer watchPassword(@RequestBody WatchUserDto watchUserDto){
        Integer integer = userService.watchPassword(watchUserDto.getPassword(),watchUserDto.getUserId());
        System.out.println(integer);
        return integer;
    }

    @ApiOperation(value = "上传头像",notes = "上传头像")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Object upload(@RequestParam("file") CommonsMultipartFile uploadFile,
                         @RequestParam("userId") Integer userId) throws IOException {
        System.out.println("111111111111111" + userId);
//        String path = "F:\\class\\新建文件夹 (2)\\" + uploadFile.getOriginalFilename();
        String img = UUID.randomUUID() + uploadFile.getOriginalFilename();
        String path = "F:\\class\\第三阶段\\新建文件夹 (2)\\ourNewsWebSite\\src\\main\\webapp\\images\\" + img;
        System.out.println(path);
        File file = new File(path);
        uploadFile.transferTo(file);
        Integer integer = userService.editUserImg("images/" + img,userId);
        return "index";
    }
}
