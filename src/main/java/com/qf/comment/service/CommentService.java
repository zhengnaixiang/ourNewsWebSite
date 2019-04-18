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
    /**
     * 添加对文章评论或者对评论回复
     * @param commentVo
     * return
     */
    boolean addGuestComment(CommentVo commentVo);

}
