package com.qf.newsPaper.service;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.vo.NewsPaperData;

import java.util.List;

public interface NewsPaperService {
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
     * @return 返回是否修改成功
     */
    public Boolean updateNewsData(NewsPaperData newsPaperData);

    /**
     * 通过新闻的类别id，获取该类别下一定数量的新闻
     * @param class_id
     * @return
     */
    public List<NewsPaperAndAuthor> getNewsByCategoryId(int class_id);
}
