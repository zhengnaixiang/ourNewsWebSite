package com.qf.newsPaper.vo;

import lombok.Data;

/**
 * 这个类用于接收当用户发布新闻时候的数据
 */
@Data
public class NewsAndOwner {
//    新闻作者的id
    int user_id;
//    新闻的标题
    String np_title;
//    新闻的封面
    String np_image;
//    新闻内容
    String np_content;
//    新闻的类别
    int classes;
}
