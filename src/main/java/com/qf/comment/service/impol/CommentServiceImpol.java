package com.qf.comment.service.impol;

import com.qf.comment.dto.CommentSeachDto;
import com.qf.comment.mapper.CommentMapper;
import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import com.qf.comment.vo.CommentSeachVo;
import com.qf.comment.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpol implements CommentService {

    @Autowired(required = false)
    private CommentMapper commentMapper;

    public boolean addComment(CommentVo commentVo) {
        return commentMapper.addCommentBy(commentVo) > 0;
    }

    public List<Comment> getCommentByNpId(int np_id) {
        return commentMapper.getCommentByNpId(np_id);
    }

    public List<Comment> getNpCommentByUserId(int np_id, int user_id) {
        return commentMapper.getNpCommentByUserId(np_id,user_id);
    }

    public boolean deleteComment(int comment_id, int user_id) {
        return commentMapper.deleteCommentByUser(comment_id,user_id) > 0;
    }

    @Override
    public List<CommentSeachDto> searchCommentByLike(CommentSeachVo commentSeachVo) {
        return commentMapper.searchCommentByLike(commentSeachVo);
    }
}