package com.qf.newsPaper.pojo;

import lombok.Data;

/**
 * 具体的新闻实体类
 */
@Data
public class NewsPaper {
//    新闻的id
    int np_id;
//    作者id
    int user_id;
//    作者笔名
    String alias;
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

}
