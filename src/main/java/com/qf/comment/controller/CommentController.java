package com.qf.comment.controller;

import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentVo;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    private List<Comment> commentList;

    /**
     * 发表评论
     * 发表评论者id从session里获取,防止前端欺骗
     * @param comment
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "addComment",method = RequestMethod.POST)
    public String addComment(@RequestBody Comment comment, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        comment.setUser_id(userInfo.getUser_id());
        return commentService.addComment(comment)?"true":"false";
    }

    /**
     * 获取新闻浏览页下所有评论内容
     * @param np_id
     * @return
     */
    @RequestMapping(value = "getCommentByNpId",method = RequestMethod.GET)
    public Object getAllCommentByNpId(@RequestParam int np_id){
        commentList = commentService.getAllCommentByNpId(np_id);
        return commentList;
    }

    /**
     * 根据当前用户id获取可见评论
     * @param np_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "getAllCommentByUserId",method = RequestMethod.GET)
    public Object getAllCommentByUserId(@RequestParam int np_id, int user_id){
        commentList = commentService.getAllCommentByUserId(np_id,user_id);
        return commentList;
    }

    @RequestMapping(value = "deleteCommentFromClient",method = RequestMethod.GET)
    public int deleteCommentFromClient(@RequestParam int np_id, int user_id){
        commentList = commentService.getAllCommentByUserId(np_id,user_id);
        return 0;
    }
}
