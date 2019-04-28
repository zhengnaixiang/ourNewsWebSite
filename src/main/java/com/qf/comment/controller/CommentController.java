package com.qf.comment.controller;

import com.qf.comment.dto.CommentSeachDto;
import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentSeachVo;
import com.qf.comment.vo.CommentVo;
import com.qf.tools.Sensitive;
import com.qf.userInfo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    private Sensitive sensitive = new Sensitive();

//    private List<Comment> commentList;

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
        // 1. 检查验证码
        System.out.println(commentVo);
        String yzmServer = (String)httpSession.getAttribute("yzm");
        if (yzmServer == null || !yzmServer.equals(commentVo.getYzm())) {
            return "yzm_error";
        } else {
            // 2.检查身份
            UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
            if (userInfo == null || userInfo.getUser_id()<1) {
                return "user_error";
            } else {
                // 3.检查内容
                String voContent = commentVo.getComment_content();
                String newContent = sensitive.replaceSensitiveWord(voContent, "*");
                System.out.println("替换后"+newContent);
                if (!voContent.equals(newContent)) {
                    return newContent;
                } else {
                    // 4. 发表评论
                    commentVo.setUser_id(userInfo.getUser_id());
                    return commentService.addComment(commentVo)?"true":"false";
                }
            }
        }
    }

    /**
     * 获取新闻浏览页下所有评论内容
     * @param np_id
     * @return
     */
    @RequestMapping(value = "getCommentByNpId",method = RequestMethod.GET)
    public Object getCommentByNpId(@RequestParam int np_id){
        return commentService.getCommentByNpId(np_id);
    }

    /**
     * 根据当前用户id获取可见评论
     * @param np_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "getNpCommentByUserId",method = RequestMethod.GET)
    public Object getNpCommentByUserId(@RequestParam int np_id, int user_id){
        System.out.println("进来的np_id"+np_id+":"+user_id);
        return commentService.getNpCommentByUserId(np_id,user_id);
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
        return "true";
    }

    /**
     * 评论管理搜索接口
     * @param commentSeachVo
     * @return
     */
    @RequestMapping(value = "searchCommentByLike")
    public Object searchCommentByLike(@RequestBody(required=false) CommentSeachVo commentSeachVo){
        System.out.println(commentSeachVo);
        List<CommentSeachDto> commentSeachDtos = commentService.searchCommentByLike(commentSeachVo);
        System.out.println(commentSeachDtos);
        return "true";
    }
}