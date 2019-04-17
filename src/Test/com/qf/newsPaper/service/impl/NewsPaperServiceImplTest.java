package com.qf.newsPaper.service.impl;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsAndOwner;
import com.qf.newsPaper.vo.NewsPaperData;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class NewsPaperServiceImplTest {
    private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    private static NewsPaperService newsPaperService=context .getBean(NewsPaperService.class);


    @Test
    public void acquireNewsByNewsId(){
        int np_id=1;
        NewsPaperAndAuthor newsPaperAndAuthor = newsPaperService.acquireNewsByNewsId(np_id);
        newsPaperAndAuthor.toString();
        System.out.println(newsPaperAndAuthor);
    }


    @Test
    public void updateNewsData(){
        NewsPaperData newsPaperData = new NewsPaperData();
        newsPaperData.setNp_id(1);
        newsPaperData.setNp_likes(13);
        newsPaperData.setNp_reading(14);
        Boolean aBoolean = newsPaperService.updateNewsData(newsPaperData);
        System.out.println(aBoolean);
    }

    @Test
    public void getNewsByCategoryId(){
        int class_id=1;
        List<NewsPaperAndAuthor> newsByCategoryId = newsPaperService.getNewsByCategoryId(class_id);
        System.out.println(newsByCategoryId);
    }

    @Test
    public void publishNewsByUser(){
        NewsAndOwner newsAndOwner = new NewsAndOwner();
        newsAndOwner.setUser_id(4);
        newsAndOwner.setNp_content("小葵花妈妈课堂开课了");
        newsAndOwner.setNp_image("wu");
        newsAndOwner.setNp_title("好好吃放");
        Boolean aBoolean = newsPaperService.publishNewsByUser(newsAndOwner);
        System.out.println(aBoolean);
    }


    @Test
    public void updateNewsStatusToZero(){
        List<Integer> newsId=new ArrayList<Integer>();
        newsId.add(2);
        newsId.add(3);
        newsId.add(4);
        NewsPaperData newsPaperData = new NewsPaperData();
        newsPaperData.setNewsId(newsId);
        Boolean aBoolean = newsPaperService.updateNewsStatusToZero(newsPaperData);
        System.out.println(aBoolean);
    }

}
