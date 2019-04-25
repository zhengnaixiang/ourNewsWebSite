package com.qf.comment.vo;

public class CommentSeachVo {
    String dateBegin;
    String dateEnd;
    String user_alias;
    String np_title;

    // 评论状态
    int status;

    @Override
    public String toString() {
        return "CommentSeachVo{" +
                "dateBegin='" + dateBegin + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", user_alias='" + user_alias + '\'' +
                ", np_title='" + np_title + '\'' +
                ", status=" + status +
                '}';
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String user_alias) {
        this.user_alias = user_alias;
    }

    public String getNp_title() {
        return np_title;
    }

    public void setNp_title(String np_title) {
        this.np_title = np_title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
