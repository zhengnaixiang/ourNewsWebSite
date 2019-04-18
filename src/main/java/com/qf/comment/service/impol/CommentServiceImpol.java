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

    @Autowired
    private CommentMapper commentMapper;

    public boolean addComment(Comment comment) {
        return commentMapper.addCommentBy(comment)>0;
    }
}
