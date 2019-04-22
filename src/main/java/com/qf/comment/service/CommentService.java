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
    List<Comment> getCommentByNpId(int np_id);

    /**
     * 获取新闻内容下方当前登录用户可见评论
     * @param np_id
     * @param user_id
     * @return
     */
    List<Comment> getNpCommentByUserId(int np_id, int user_id);

    /**
     * 校验用户是否有资格删除评论
     * 有则删除指定评论
     * @param comment_id
     * @param user_id
     * @return
     */
    boolean deleteComment(int comment_id, int user_id);
}
