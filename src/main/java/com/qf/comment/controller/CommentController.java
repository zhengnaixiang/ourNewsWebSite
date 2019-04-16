package com.qf.comment.controller;

import com.qf.comment.pojo.Comment;
import com.qf.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "addCommentBy",method = RequestMethod.POST)
    public String addCommentBy(@RequestBody Comment comment){

        return commentService.addCommentBy(comment)?"true":"false";
    }


}
