package com.qf.comment.pojo;

import java.sql.Date;

public class Comment {
    int comment_id;
    int parent_id;
    int np_id;
    Date comment_date;
    String comment_content;
    int user_id;
    boolean status;

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", parent_id=" + parent_id +
                ", np_id=" + np_id +
                ", comment_date=" + comment_date +
                ", comment_content='" + comment_content + '\'' +
                ", user_id=" + user_id +
                ", status=" + status +
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

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
