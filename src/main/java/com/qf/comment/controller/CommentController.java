package com.qf.comment.controller;

import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentVo;
import com.qf.userInfo.pojo.UserInfo;
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
     * 服务端验证码从session里获取。
     * @param commentVo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "addComment",method = RequestMethod.POST)
    public String addComment(@RequestBody CommentVo commentVo, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        commentVo.setUser_id(userInfo.getUser_id());
        String yzmServer = (String)httpSession.getAttribute("yzm");
        if (yzmServer != null && yzmServer.equals(commentVo.getYzm())) {
                return commentService.addComment(commentVo)?"true":"false";
            }
        return "yzm_error";
    }

    /**
     * 获取新闻浏览页下所有评论内容
     * @param np_id
     * @return
     */
    @RequestMapping(value = "getCommentByNpId",method = RequestMethod.GET)
    public Object getCommentByNpId(@RequestParam int np_id){
        commentList = commentService.getCommentByNpId(np_id);
        return commentList;
    }

    /**
     * 根据当前用户id获取可见评论
     * @param np_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "getNpCommentByUserId",method = RequestMethod.GET)
    public Object getNpCommentByUserId(@RequestParam int np_id, int user_id){
        commentList = commentService.getNpCommentByUserId(np_id,user_id);
        return commentList;
    }

    /**
     * 用户删除自己评论
     * @param comment_id
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "deleteComment")
    public String deleteCommentByUser(@RequestParam int comment_id, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        if (user_id > 0 && comment_id > 0) {
            if (commentService.deleteComment(comment_id,user_id)) {
                return "true";
            }
        }
        return "false";
    }

    /**
     * 修改评论
     * @param comment_id
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "updateComment",method = RequestMethod.POST)
    public String updateComment(@RequestParam int comment_id, HttpSession httpSession){
        // 暂不支持用户修改评论
        return "false";
    }

}
