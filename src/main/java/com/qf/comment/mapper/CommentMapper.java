package com.qf.comment.mapper;

import com.qf.comment.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int addCommentBy(Comment comment);

    List<Comment> getAllCommentByNpId(int np_id);

    List<Comment> getAllCommentByUserId(@Param("np_id")int np_id, @Param("user_id")int user_id);

}
