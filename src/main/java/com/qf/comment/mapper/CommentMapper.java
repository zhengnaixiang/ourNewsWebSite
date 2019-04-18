package com.qf.comment.mapper;

import com.qf.comment.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    int addCommentBy(Comment comment);

    List<Comment> getAllCommentByNpId(int np_id);
}
