package com.qf.comment.service;

import com.qf.comment.pojo.Comment;
import com.qf.comment.vo.CommentVo;

import java.util.List;

public interface CommentService {
    /**
     * 添加普通评论
     * @param comment
     * @return
     */
    boolean addComment(Comment comment);

    /**
     * 获取新闻内容下方全部评论
     * @param np_id
     * @return
     */
    List<Comment> getAllCommentByNpId(int np_id);

    /**
     * 获取新闻内容下方当前登录用户可见评论
     * @param np_id
     * @param user_id
     * @return
     */
    List<Comment> getAllCommentByUserId(int np_id, int user_id);
}
