package com.qf.comment.service.impol;

import com.qf.comment.mapper.CommentMapper;
import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpol implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public boolean addCommentBy(Comment comment){
        return commentMapper.addCommentBy(comment)>0;
    }
}
