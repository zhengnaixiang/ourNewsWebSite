package com.qf.newsPaper.controller;

import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsAndOwner;
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

  /**
   * 通过新闻的类别id，获取该类别下一定数量的排好序的新闻
   * @param class_id
   * @return
   */
    @RequestMapping(value = "getNewsByCategoryId",method = RequestMethod.GET)
    public Object getNewsByCategoryId(@RequestParam int class_id) {
      return newsPaperService.getNewsByCategoryId(class_id);
    }

  /**
   * 接收用户发布新闻的数据，将其保存到数据库
   * @param newsAndOwner
   * @return
   */
    @RequestMapping(value = "publishNewsByUser",method = RequestMethod.POST)
    public String publishNewsByUser(@RequestBody NewsAndOwner newsAndOwner){
      return newsPaperService.publishNewsByUser(newsAndOwner).toString();
    }

  /**
   * 通过用户id，获取到该用户所撰写的新闻集合。
   * @param user_id 用户id
   * @return 返回新闻的集合
   */
    @RequestMapping(value = "getAuthorNewsByUserId",method = RequestMethod.GET)
    public Object getAuthorNewsByUserId(@RequestParam int user_id){
      return newsPaperService.getAuthorNewsByUserId(user_id);
    }

  /**
   * 根据用户传入进来的新闻集合id，进行删除新闻的操作
   * @param newsPaperData 将集合包装成的对象
   * @return 返回是否删除成功的结果
   */
  @RequestMapping(value = "updateNewsStatusToZero",method = RequestMethod.POST)
    public String updateNewsStatusToZero(@RequestBody NewsPaperData newsPaperData){
      return newsPaperService.updateNewsStatusToZero(newsPaperData).toString();
    }
}
