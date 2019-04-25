package com.qf.comment.dto;

public class CommentSeachDto {

    // 评论相关
    int comment_id;
    String comment_content;
    String comment_date;
    int status;
    // 评论人
    int user_id;
    String user_alias;

    // 被评论新闻
    int np_id;
    String np_title;

    @Override
    public String toString() {
        return "CommentSeachDto{" +
                "comment_id=" + comment_id +
                ", comment_content='" + comment_content + '\'' +
                ", comment_date='" + comment_date + '\'' +
                ", status=" + status +
                ", user_id=" + user_id +
                ", user_alias='" + user_alias + '\'' +
                ", np_id=" + np_id +
                ", np_title='" + np_title + '\'' +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String user_alias) {
        this.user_alias = user_alias;
    }

    public int getNp_id() {
        return np_id;
    }

    public void setNp_id(int np_id) {
        this.np_id = np_id;
    }

    public String getNp_title() {
        return np_title;
    }

    public void setNp_title(String np_title) {
        this.np_title = np_title;
    }
}
