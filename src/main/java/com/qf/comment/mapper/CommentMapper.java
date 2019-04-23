package com.qf.comment.mapper;

import com.qf.comment.pojo.Comment;
import com.qf.comment.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int addCommentBy(CommentVo commentVo);

    List<Comment> getCommentByNpId(int np_id);

    List<Comment> getNpCommentByUserId(@Param("np_id")int np_id, @Param("user_id")int user_id);

//    int checkCommentByUserId(@Param("comment_id")int comment_id, @Param("user_id")int user_id);
    int deleteCommentByUser(@Param("comment_id")int comment_id, @Param("user_id")int user_id);
}
