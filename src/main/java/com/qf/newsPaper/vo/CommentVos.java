package com.qf.newsPaper.vo;

import lombok.Data;

@Data
public class CommentVos {
    /*当前页数*/
    int currentPage;
    /*每页展示的数量*/
    int pageSize;
    int user_id;
}
