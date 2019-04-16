package com.qf.comment.service;

import com.qf.comment.pojo.Comment;

public interface CommentService {
    /**
     * 添加对文章评论或者对评论回复
     * @param comment
     * @return
     */
    boolean addCommentBy(Comment comment);
}
