package com.qf.comment.service.impol;

import com.qf.comment.mapper.CommentMapper;
import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentVo;
import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpol implements CommentService {

  /*  @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;*/

    public boolean addGuestComment(CommentVo commentVo){
        //添加匿名评论
        UserInfo u1 = new UserInfo();
        u1.setUsername(commentVo.getEmail());
        u1.setUser_alias("游客");
        //帮其注册一个空密码账号，以后注册了可继承现在的评论
       /* if (userInfoMapper.addUserInfo(u1) == 0) {
            //注册失败
            return false;
        } else {
            int user_id = userInfoMapper.selectUserInfoIdBy(u1).get(0).getUser_id();
            Comment comment = new Comment();
            comment.setUser_id(user_id);
            comment.setNp_id(commentVo.getNp_id());
            comment.setParent_id(commentVo.getParent_id());
            comment.setComment_content(commentVo.getContent());
            return commentMapper.addCommentBy(comment)>0;
        }*/
       return false;
    }
}
