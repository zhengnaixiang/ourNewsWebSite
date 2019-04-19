package com.qf.newsPaper.dto;

import lombok.Data;

@Data
public class NewsPaperAndCategory {
//  新闻的id
    int np_id;
//    新闻的标题
    String np_title;
//    新闻的发布日期
    String np_date;
//    新闻的喜爱量
    int np_likes;
//    新闻的阅读量
    int np_reading;
//    新闻的类别名称
    String class_name;
//    新闻的封面
    String np_image;
//    新闻的内容
    String np_content;
}
