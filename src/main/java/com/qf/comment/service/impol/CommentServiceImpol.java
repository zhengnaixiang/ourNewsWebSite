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

import java.util.List;

@Service
public class CommentServiceImpol implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

//    private static ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
//    private static CommentMapper commentMapper=context .getBean(CommentMapper.class);

    public boolean addComment(Comment comment) {
        System.out.println(comment);
        return commentMapper.addCommentBy(comment) > 0;
    }

    public List<Comment> getCommentByNpId(int np_id) {
        return commentMapper.getCommentByNpId(np_id);
    }

    public List<Comment> getNpCommentByUserId(int np_id, int user_id) {
        return commentMapper.getNpCommentByUserId(np_id,user_id);
    }

    public boolean deleteComment(int comment_id, int user_id) {
        if (commentMapper.checkCommentByUserId(comment_id,user_id) > 0) {
            return commentMapper.deleteCommentByUser(comment_id) > 0;
        }
        return false;
    }
}