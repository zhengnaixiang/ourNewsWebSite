package com.qf.comment.vo;

public class CommentVo {
    int np_id;
    int parent_id;
    String alias;
    String email;
    String content;

    @Override
    public String toString() {
        return "CommentVo{" +
                "np_id=" + np_id +
                ", parent_id=" + parent_id +
                ", alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
