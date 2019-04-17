package com.qf.newsPaper.controller;

import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsPaperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 此类用于将新闻的相关数据写到前端
 */
@RestController
public class NewsPaperController {

  /*  @Autowired
    NewsPaperService newsPaperService;*/
  private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    private static NewsPaperService newsPaperService=context .getBean(NewsPaperService.class);

    /**
     * 通过前端的点击事件，返回具体的新闻信息，以及该新闻作者的相关属性
     * @param np_id 新闻的id
     * @return 返回新闻的信息以及该新闻作者的相关属性
     */
    @RequestMapping(value = "acquireNewsByNewsId",method = RequestMethod.GET)
    public Object acquireNewsByNewsId(@RequestParam int np_id){
        return newsPaperService.acquireNewsByNewsId(np_id);
    }

    /**
     * 更改新闻的参数，阅读量，喜爱量
     * @param newsPaperData 传入的参数，里面包含喜爱量，阅读量，新闻的id
     * @return 返回是否修改成功
     */
    @RequestMapping(value = "updateNewsData",method = RequestMethod.POST)
    public String updateNewsData(@RequestBody NewsPaperData newsPaperData){
        return newsPaperService.updateNewsData(newsPaperData).toString();
    }
}
