package com.qf.newsPaper.vo;

import lombok.Data;

import java.util.List;

/**
 * 前端向后端发送的数据，主要是新闻的id，新闻的阅读量和喜爱量
 */
@Data
public class NewsPaperData {
    int np_id;
    int np_reading;
    String np_likes;
    double np_like;
    List<Integer> newsId;
}
