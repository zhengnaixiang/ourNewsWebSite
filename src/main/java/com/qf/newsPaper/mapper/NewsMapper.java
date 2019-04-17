package com.qf.newsPaper.mapper;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.dto.NewsPaperAndCategory;
import com.qf.newsPaper.vo.NewsAndOwner;
import com.qf.newsPaper.vo.NewsPaperData;

import java.util.List;

/**
 * 新闻的mapper
 */
public interface NewsMapper {

    /**
     * 根据新闻的id，获取新闻及作者的相关内容
     * 就是用户点击事件后返回到前端的内容
     * @param np_id
     * @return
     */
    public NewsPaperAndAuthor acquireNewsByNewsId(int np_id);

    /**
     * 更改新闻的参数，阅读量，喜爱量
     * @param newsPaperData 传入的参数，里面包含喜爱量，阅读量，新闻的id
     * @return 返回影响行数
     */
    public int updateNewsData(NewsPaperData newsPaperData);

    /**
     * 通过新闻的类别id，获取该类别下一定数量的排好序的新闻
     * @param class_id
     * @return
     */
    public List<NewsPaperAndAuthor> getNewsByCategoryId(int class_id);

    /**
     * 接收用户发布新闻的数据，并将其保存到数据库
     * @param newsAndOwner 用户id，和一些新闻的内容
     * @return 影响行数
     */
    public int publishNewsByUser(NewsAndOwner newsAndOwner);

    /**
     * 通过用户id，获取到该用户所撰写的新闻集合。
     * @param user_id 用户id
     * @return 返回新闻的集合
     */
    public List<NewsPaperAndCategory> getAuthorNewsByUserId(int user_id);

    /**
     * 根据用户传进来的id，进行单个删除和批量删除
     * @param newsPaperData 用户传进来的待删除的新闻id集合
     * @return 返回一个影响行数
     */
    public int updateNewsStatusToZero(NewsPaperData newsPaperData);
}
