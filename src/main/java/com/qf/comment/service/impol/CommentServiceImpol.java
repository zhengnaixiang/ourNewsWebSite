package com.qf.comment.service.impol;

import com.qf.comment.mapper.CommentMapper;
import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentVo;
import com.qf.newsPaper.mapper.NewsMapper;
import com.qf.newsPaper.service.NewsPaperService;
import com.qf.userInfo.mapper.UserInfoMapper;
import com.qf.userInfo.pojo.UserInfo;
import com.qf.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpol implements CommentService {

     /*  @Autowired
      private CommentMapper commentMapper;
      @Autowired
      private UserInfoMapper userInfoMapper;*/

    private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    private static CommentMapper commentMapper=context .getBean(CommentMapper.class);

    public boolean addComment(Comment comment) {
        return commentMapper.addCommentBy(comment) > 0;
    }
}