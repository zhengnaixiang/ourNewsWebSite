package com.qf.comment.service;

import com.qf.comment.pojo.Comment;
import com.qf.comment.vo.CommentVo;

public interface CommentService {
    /**
     * 添加普通评论
     * @param comment
     * @return
     */
    boolean addComment(Comment comment);
}
