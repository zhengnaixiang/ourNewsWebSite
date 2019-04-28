package com.qf.comment.vo;

public class CommentVo {

    int user_id;
    int np_id;
    int parent_id;
    String comment_content;
    String yzm;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNp_id() {
        return np_id;
    }

    public void setNp_id(int np_id) {
        this.np_id = np_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    @Override
    public String toString() {
        return "CommentVos{" +
                "user_id=" + user_id +
                ", np_id=" + np_id +
                ", parent_id=" + parent_id +
                ", comment_content='" + comment_content + '\'' +
                ", yzm='" + yzm + '\'' +
                '}';
    }
}
