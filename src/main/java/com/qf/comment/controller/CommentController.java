package com.qf.comment.controller;

import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentVo;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "addGuestComment",method = RequestMethod.POST)
    public String addGuestComment(@RequestBody CommentVo commentVo){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(commentVo.getEmail());
        List<UserInfo> userInfos = userInfoService.selectUserInfoIdBy(userInfo);
        if (userInfos!=null && !userInfos.isEmpty()) {
            //要求登录
            return "-1";
        } else {
            //添加游客评论
            return commentService.addGuestComment(commentVo)?"true":"false";
        }
    }


}
