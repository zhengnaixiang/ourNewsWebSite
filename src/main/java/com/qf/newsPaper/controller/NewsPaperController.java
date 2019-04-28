package com.qf.newsPaper.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.newsPaper.dto.CommentDto;
import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.dto.NewsPaperAndCategory;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.AuthorNews;
import com.qf.newsPaper.vo.CommentVos;
import com.qf.newsPaper.vo.NewsAndOwner;
import com.qf.newsPaper.vo.NewsPaperData;
import com.qf.userInfo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 此类用于将新闻的相关数据写到前端
 */
@RestController
public class NewsPaperController {

    @Autowired
    NewsPaperService newsPaperService;


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
        System.out.println(newsPaperData);
        String np_likes = newsPaperData.getNp_likes();
        String[] split = np_likes.split("=");
        if(split[0].equals("点赞")){
            newsPaperData.setNp_like((double)Integer.parseInt(split[1])-0.5);
        }else {
            newsPaperData.setNp_like((double)Integer.parseInt(split[1])+0.5);
        }
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
        int pageCount = list.size()%authorNews.getPageSize()==0?list.size()/authorNews.getPageSize():(list.size()/authorNews.getPageSize()+1);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<NewsPaperAndAuthor> list1 = new ArrayList<>();
        for(int i = 0; i < authorNews.getPageSize() ;i++) {
            if((authorNews.getCurrentPage() - 1) * authorNews.getPageSize()+i<list.size())
                list1.add(list.get((authorNews.getCurrentPage() - 1) * authorNews.getPageSize()+i));
            else break;
        }
        map.put("list",list1 );
        map.put("currentPage",authorNews.getCurrentPage() );
        map.put("pageCount",pageCount);
        map.put("pageSize",authorNews.getPageSize());
        list.clear();
        return map;
    }

    /**
     * 获取指定类别下的新闻，并按照热度，进行降序输出
     * @param authorNews
     * @return
     */
    @RequestMapping(value = "getHotNewsByCategoryId",method = RequestMethod.POST)
    public Object getHotNewsByCategoryId(@RequestBody AuthorNews authorNews){
        PageHelper.startPage(authorNews.getCurrentPage(),authorNews.getPageSize());
        List<NewsPaperAndAuthor> list = newsPaperService.getHotNewsByCategoryId(authorNews.getClass_id());
        int pageCount = list.size()%authorNews.getPageSize()==0?list.size()/authorNews.getPageSize():(list.size()/authorNews.getPageSize()+1);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<NewsPaperAndAuthor> list1 = new ArrayList<>();
        for(int i = 0; i < authorNews.getPageSize() ;i++) {
            if((authorNews.getCurrentPage() - 1) * authorNews.getPageSize()+i<list.size())
                list1.add(list.get((authorNews.getCurrentPage() - 1) * authorNews.getPageSize()+i));
            else break;
        }
        map.put("list",list1 );
        map.put("currentPage",authorNews.getCurrentPage() );
        map.put("pageCount",pageCount);
        map.put("pageSize",authorNews.getPageSize());
        list.clear();
        return map;
    }

  /**
   * 接收用户发布新闻的数据，将其保存到数据库
   * @param newsAndOwner
   * @return
   */
    @RequestMapping(value = "publishNewsByUser",method = RequestMethod.POST)
    public String publishNewsByUser(HttpSession httpSession, @RequestBody NewsAndOwner newsAndOwner){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        newsAndOwner.setUser_id(userInfo.getUser_id());
        System.out.println("获取到的标题"+newsAndOwner.getNp_title());
        System.out.println("获取到的内容"+newsAndOwner.getNp_content());
        System.out.println("处理的结果"+newsPaperService.publishNewsByUser(newsAndOwner));
        return newsPaperService.publishNewsByUser(newsAndOwner);
    }

  /**
   * 通过用户id，获取到该用户所撰写的新闻集合,进行分页展示
   * @param authorNews 包含用户id与当前页数，以及每页展示的数量
   * @return 返回新闻的集合
   */
    @RequestMapping(value = "getAuthorNewsByUserId",method = RequestMethod.POST)
    public Object getAuthorNewsByUserId(HttpSession session, @RequestBody AuthorNews authorNews){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        authorNews.setUser_id(userInfo.getUser_id());
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

    /**
     * 根据新闻的id进行单个删除的操作
     * @param newsPaperData
     * @return
     */
    @RequestMapping(value = "deleteSingleNews",method = RequestMethod.POST)
    public String deleteSingleNews(@RequestBody NewsPaperData newsPaperData){
      return newsPaperService.deleteSingleNews(newsPaperData.getNp_id()).toString();
    }

    /**
     * 获取所有新闻文章文本，用于添加新新闻时的文章查重
     * @return
     */
    @RequestMapping(value = "FindRepetitiveNews",method = RequestMethod.POST)
    public Boolean FindRepetitiveNews(@RequestParam String content) {
        System.out.println("进入查重方法");
        return newsPaperService.FindRepetitiveNews(content);
    }

    /**
     * 新增新闻的查询功能
     * @param authorNews
     * @return 返回相应的结果集
     */
    @RequestMapping(value = "getNewsByBlurCondition",method = RequestMethod.POST)
    public Object getNewsByBlurCondition(@RequestBody AuthorNews authorNews){
        PageHelper.startPage(authorNews.getCurrentPage(), authorNews.getPageSize());
        List<NewsPaperAndAuthor> list = newsPaperService.getNewsByBlurCondition(authorNews);
        PageInfo<NewsPaperAndAuthor> contentList= new PageInfo<NewsPaperAndAuthor>(list);
        return contentList;
    }

    /**
     * 获取所有的评论列表数据,根据用户id
     * @return
     */
    @RequestMapping(value = "getCommentByUserId",method = RequestMethod.POST)
    public Object getCommentByUserId(HttpSession session,@RequestBody CommentVos commentVos){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        commentVos.setUser_id(userInfo.getUser_id());
        PageHelper.startPage(commentVos.getCurrentPage(), commentVos.getPageSize());
        List<CommentDto> allComments = newsPaperService.getCommentByUserId(commentVos.getUser_id());
        PageInfo<CommentDto> commentDtoPageInfo = new PageInfo<CommentDto>(allComments);
        return commentDtoPageInfo;
    }
}
