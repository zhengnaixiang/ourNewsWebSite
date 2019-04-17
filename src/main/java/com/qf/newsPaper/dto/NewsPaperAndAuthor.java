package com.qf.newsPaper.dto;

import lombok.Data;

/**
 * 此类表示单个新闻展示页面所需的具体信息及头像，需要往前端发送的数据
 */
@Data
public class NewsPaperAndAuthor {
    //    新闻的id
    int np_id;
    //    作者id
    int user_id;
    //    作者笔名
    String user_alias;
    //    新闻标题
    String np_title;
    //    新闻发布日期
    String np_date;
    //    新闻封面
    String np_image;
    //    新闻内容
    String np_content;
    //    新闻阅读量
    int np_reading;
    //    新闻点赞量
    int np_likes;
    //    新闻的状态值
    boolean np_status;
    //   用户的头像
    String user_imageUrl;
    //新闻的类别名称
    String class_name;
}
