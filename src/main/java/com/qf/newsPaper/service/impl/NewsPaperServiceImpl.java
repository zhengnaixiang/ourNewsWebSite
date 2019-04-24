package com.qf.newsPaper.service.impl;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.dto.NewsPaperAndCategory;
import com.qf.newsPaper.mapper.NewsMapper;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsAndOwner;
import com.qf.newsPaper.vo.NewsPaperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsPaperServiceImpl implements NewsPaperService {

    @Autowired
    NewsMapper newsMapper;

    /**
     * 根据新闻的id，获取到新闻的相关信息和新闻作者的相关信息
     * @param np_id 新闻的id
     * @return 新闻内容及作者的相关信息
     */
    public NewsPaperAndAuthor acquireNewsByNewsId(int np_id) {
        return this.newsMapper.acquireNewsByNewsId(np_id);
    }

    /**
     * 更改新闻的参数，阅读量，喜爱量
     * @param newsPaperData 传入的参数，里面包含喜爱量，阅读量，新闻的id
     * @return 返回是否修改成功
     */
    public Boolean updateNewsData(NewsPaperData newsPaperData) {
        return this.newsMapper.updateNewsData(newsPaperData)>0?true:false;
    }

    /**
     * 通过新闻的类别id，获取该类别下一定数量的排好序的新闻
     * @param class_id
     * @return
     */
    public List<NewsPaperAndAuthor> getNewsByCategoryId(int class_id) {
        return newsMapper.getNewsByCategoryId(class_id);
    }

    /**
     * 获取该类别的新闻，并按照热度进行降序输出
     * @param class_id
     * @return
     */
    public List<NewsPaperAndAuthor> getHotNewsByCategoryId(int class_id) {
        return newsMapper.getHotNewsByCategoryId(class_id);
    }

    /**
     * 接收用户发布新闻的数据，并将其保存到数据库
     * @param newsAndOwner 用户id，和一些新闻的内容
     * @return 是否添加成功的状态值
     */
    public Boolean publishNewsByUser(NewsAndOwner newsAndOwner) {
        return newsMapper.publishNewsByUser(newsAndOwner)>0?true:false;
    }

    /**
     * 通过用户id，获取到该用户所撰写的新闻集合。
     * @param user_id 用户id
     * @return 返回新闻的集合
     */
    public List<NewsPaperAndCategory> getAuthorNewsByUserId(int user_id) {
        return newsMapper.getAuthorNewsByUserId(user_id);
    }

    /**
     * 根据用户传进来的新闻id集合，进行删除新闻的操作
     * @param newsPaperData 用户传进来的待删除的新闻id集合
     * @return 返回是否删除成功的结果
     */
    public Boolean updateNewsStatusToZero(NewsPaperData newsPaperData) {
        return newsMapper.updateNewsStatusToZero(newsPaperData)>0?true:false;
    }

    /**
     * 根据用户id获取该用户所撰写的新闻，并进行按阅读量和喜爱量降序输出
     * @param user_id
     * @return
     */
    public List<NewsPaperAndCategory> theHotNewsByUser(int user_id) {
        return newsMapper.theHotNewsByUser(user_id);
    }
}
