package com.qf.personalInformation.controller;

import com.qf.personalInformation.dto.WatchUserDto;
import com.qf.personalInformation.dto.WatchsUserDto;
import com.qf.personalInformation.pojo.TbUserinfo;
import com.qf.personalInformation.service.UserService;
import com.qf.personalInformation.tools.ValidatorCheck;
import com.qf.personalInformation.vo.WatchUserVo;
import com.qf.userInfo.pojo.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
//    public List<WatchUserDto> watchUser(@RequestBody WatchUserVo watchUserVo){
    public List<WatchUserDto> watchUser(HttpSession httpSession){
//        System.out.println("2333333333");
        WatchUserVo watchUserVo = new WatchUserVo();
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        watchUserVo.setUserId(userInfo.getUser_id());
        List<WatchUserDto> watchUserDtos = userService.watchUser(watchUserVo.getUserId());
        return watchUserDtos;
    }


    @RequestMapping(value = "/loginTo",method = RequestMethod.GET)
    public void setSession(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession){
//        request.setAttribute("name","name");
        TbUserinfo userinfo = new TbUserinfo();
        userinfo.setUserId(32);
        System.out.println(userinfo);
        httpSession.setAttribute("userInfo",userinfo);
    }

    @RequestMapping(value = "/giveStatus",method = RequestMethod.POST)
    public Object getSession(HttpSession httpSession){
        Object userInfo = httpSession.getAttribute("userInfo");
        return userInfo != null ? userInfo : "false";
    }

    @ApiOperation(value = "用户修改",notes = "用户修改")
    @ResponseBody
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public Integer editUser(@Valid @RequestBody WatchUserDto watchUserDto, BindingResult errors,HttpSession httpSession){
        // 后台校验分页插件
        ValidatorCheck.checkParameter(errors);

        TbUserinfo userInfo = (TbUserinfo) httpSession.getAttribute("userInfo");
        watchUserDto.setUserId(userInfo.getUserId());

        Integer integer = userService.editUser(watchUserDto);
        return integer;
    }

    @ApiOperation(value = "用户修改密码",notes = "密码修改")
    @ResponseBody
    @RequestMapping(value = "/editPassword",method = RequestMethod.POST)
    public Integer editPassword(@Valid @RequestBody WatchsUserDto watchsUserDto, BindingResult errors,HttpSession httpSession){
        // 后台校验分页插件
        ValidatorCheck.checkParameter(errors);

        TbUserinfo userInfo = (TbUserinfo) httpSession.getAttribute("userInfo");
        watchsUserDto.setUserId(userInfo.getUserId());

        Integer integer = userService.editPassword(watchsUserDto.getPassword(),watchsUserDto.getUserId());
        return integer;
    }

    @ApiOperation(value = "查看用户旧密码是否正确",notes = "查看旧密码")
    @ResponseBody
    @RequestMapping(value = "/watchPassword",method = RequestMethod.POST)
    public Integer watchPassword(@RequestBody WatchUserDto watchUserDto,HttpSession httpSession){
        TbUserinfo userInfo = (TbUserinfo) httpSession.getAttribute("userInfo");
        System.out.println(userInfo.getUserId());
        watchUserDto.setUserId(userInfo.getUserId());

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
