package com.xebia.BloggingApplication.service.Impl;

import com.xebia.BloggingApplication.entites.Comment;
import com.xebia.BloggingApplication.entites.Posts;
import com.xebia.BloggingApplication.exceptions.ResouceNotFoundException;
import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.CommentDto;
import com.xebia.BloggingApplication.repositories.CommentRepository;
import com.xebia.BloggingApplication.repositories.PostRepository;
import com.xebia.BloggingApplication.service.CommentService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, int postId) {
        Posts post = this.postRepository.findById(postId).orElseThrow(()->new ResouceNotFoundException("Post","Id",postId));
        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPosts(post);
        Comment savedComment = this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);

    }

    @Override
    public void deleteComment(int commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()->new ResouceNotFoundException("Comment","Id",commentId));
        this.commentRepository.delete(comment);

    }
}
