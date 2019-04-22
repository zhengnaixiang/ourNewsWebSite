package com.qf.comment.pojo;

import java.util.List;

public class Comment {
    // 本评论id
    int comment_id;
    // 回复对象评论id
    int parent_id;
    // 新闻id
    int np_id;
    // 本评论发表时间
    String comment_date;
    // 本评论内容
    String comment_content;
    // 本评论发表人id
    int user_id;
    // 评论状态。0未审核，1可显示，2用户删除状态
    int status;
    // 评论的用户别名
    String user_alias;
    // 评论的用户头像
    String user_imageUrl;
    // 评论下方的跟帖
    List<Comment> commentList;

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", parent_id=" + parent_id +
                ", np_id=" + np_id +
                ", comment_date='" + comment_date + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", user_id=" + user_id +
                ", status=" + status +
                ", user_alias='" + user_alias + '\'' +
                ", user_imageUrl='" + user_imageUrl + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getNp_id() {
        return np_id;
    }

    public void setNp_id(int np_id) {
        this.np_id = np_id;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String user_alias) {
        this.user_alias = user_alias;
    }

    public String getUser_imageUrl() {
        return user_imageUrl;
    }

    public void setUser_imageUrl(String user_imageUrl) {
        this.user_imageUrl = user_imageUrl;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
