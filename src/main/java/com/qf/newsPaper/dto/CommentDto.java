package com.qf.newsPaper.dto;

import lombok.Data;

@Data
public class CommentDto {
    /*评论的id*/
    int comment_id;
    /*评论内容*/
    String comment_content;
    /*评论人*/
    String user_alias;
    /*评论的文章标题*/
    String np_title;
    /*评论的日期*/
    String comment_date;
    /*评论的状态*/
    int status;
    /*当前页数*/
    int currentPage;
    /*每页展示的数量*/
    int pageSize;
    /*新闻的id*/
    int np_id;
}
