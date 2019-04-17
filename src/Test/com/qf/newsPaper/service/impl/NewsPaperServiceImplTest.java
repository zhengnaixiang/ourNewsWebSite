package com.qf.newsPaper.service.impl;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsPaperData;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        List<NewsPaperAndAuthor> newsByCategoryId = newsPaperService.getNewsByCategoryId(1);
        System.out.println(newsByCategoryId);
    }

}
