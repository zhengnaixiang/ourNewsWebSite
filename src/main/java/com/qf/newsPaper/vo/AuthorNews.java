package com.qf.newsPaper.vo;

import lombok.Data;

@Data
public class AuthorNews {
    /*新闻作者的id*/
    int user_id;
    /*当前页数*/
    int currentPage;
    /*每页展示的新闻数据*/
    int pageSize;
    /*新闻的类别id*/
    int class_id;
}
