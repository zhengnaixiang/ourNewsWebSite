package com.qf.newsPaper.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.dto.NewsPaperAndCategory;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.AuthorNews;
import com.qf.newsPaper.vo.NewsAndOwner;
import com.qf.newsPaper.vo.NewsPaperData;
import com.qf.userInfo.pojo.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
   * @param
   * @return
   */
    @RequestMapping(value = "getNewsByCategoryId",method = RequestMethod.POST)
    public Object getNewsByCategoryId(@RequestBody AuthorNews authorNews) {
      PageHelper.startPage(authorNews.getCurrentPage(), authorNews.getPageSize());
      List<NewsPaperAndAuthor> list = newsPaperService.getNewsByCategoryId(authorNews.getClass_id());
      PageInfo<NewsPaperAndAuthor> newsPaperAndAuthorPageInfo = new PageInfo<NewsPaperAndAuthor>(list);
      return newsPaperAndAuthorPageInfo;
    }

   /**
   * 获取指定类别下的新闻，并按照热度，进行降序输出
   * @param authorNews
   * @return
   */
    @RequestMapping(value = "getHotNewsByCategoryId",method = RequestMethod.POST)
    public Object getHotNewsByCategoryId(@RequestBody AuthorNews authorNews){
      PageHelper.startPage(authorNews.getCurrentPage(),authorNews.getPageSize());
      List<NewsPaperAndAuthor> hotNewsByCategoryId = newsPaperService.getHotNewsByCategoryId(authorNews.getClass_id());
      PageInfo<NewsPaperAndAuthor> newsPaperAndAuthorPageInfo = new PageInfo<NewsPaperAndAuthor>(hotNewsByCategoryId);
      return newsPaperAndAuthorPageInfo;
    }

  /**
   * 接收用户发布新闻的数据，将其保存到数据库
   * @param newsAndOwner
   * @return
   */
    @RequestMapping(value = "publishNewsByUser",method = RequestMethod.POST)
    public String publishNewsByUser(HttpSession session, @RequestBody NewsAndOwner newsAndOwner){
      UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
      newsAndOwner.setUser_id(userInfo.getUser_id());
      return newsPaperService.publishNewsByUser(newsAndOwner).toString();
    }

  /**
   * 通过用户id，获取到该用户所撰写的新闻集合,进行分页展示
   * @param authorNews 包含用户id与当前页数，以及每页展示的数量
   * @return 返回新闻的集合
   */
    @RequestMapping(value = "getAuthorNewsByUserId",method = RequestMethod.POST)
    public Object getAuthorNewsByUserId(@RequestBody AuthorNews authorNews){
      PageHelper.startPage(authorNews.getCurrentPage(), authorNews.getPageSize());
      List<NewsPaperAndCategory> list = newsPaperService.getAuthorNewsByUserId(authorNews.getUser_id());
      PageInfo<NewsPaperAndCategory> commentDtoPageInfo = new PageInfo<NewsPaperAndCategory>(list);
      return commentDtoPageInfo;
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

  /**
   * 根据用户的id，获取该用户所撰写的新闻，并按照阅读量和喜爱量进行降序输出
   * @param authorNews
   * @return
   */
  @RequestMapping(value = "getTheHotNews",method = RequestMethod.POST)
    public Object getTheHotNews(@RequestBody AuthorNews authorNews){
    PageHelper.startPage(authorNews.getCurrentPage(), authorNews.getPageSize());
    List<NewsPaperAndCategory> list = newsPaperService.theHotNewsByUser(authorNews.getUser_id());
    PageInfo<NewsPaperAndCategory> commentDtoPageInfo = new PageInfo<NewsPaperAndCategory>(list);
    return commentDtoPageInfo;
    }
}
