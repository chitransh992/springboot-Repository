package com.xebia.BloggingApplication.service;

import com.xebia.BloggingApplication.entites.Comment;
import com.xebia.BloggingApplication.payloads.CommentDto;
import com.xebia.BloggingApplication.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto createComment(CommentDto commentDto, int postId);
    void deleteComment(int commentId);



}
