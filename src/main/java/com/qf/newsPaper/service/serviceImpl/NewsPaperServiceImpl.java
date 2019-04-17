package com.qf.newsPaper.service.serviceImpl;

import com.qf.newsPaper.dto.NewsPaperAndAuthor;
import com.qf.newsPaper.mapper.NewsMapper;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.newsPaper.vo.NewsPaperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsPaperServiceImpl implements NewsPaperService {

   /* @Autowired
    NewsMapper newsMapper;*/
   private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    private static NewsMapper  newsMapper=context .getBean(NewsMapper.class);
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
     * 通过新闻的类别id，获取该类别下一定数量的新闻
     * @param class_id
     * @return
     */
    public List<NewsPaperAndAuthor> getNewsByCategoryId(int class_id) {
        return newsMapper.getNewsByCategoryId(class_id);
    }
}
