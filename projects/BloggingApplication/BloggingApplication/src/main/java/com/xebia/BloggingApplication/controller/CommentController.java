package com.xebia.BloggingApplication.controller;

import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.CommentDto;
import com.xebia.BloggingApplication.service.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<ApiResponse> createComment(@RequestBody CommentDto commentDto, @PathVariable int postId){
        CommentDto commentDto1 = this.commentService.createComment(commentDto,postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Created Successfully", true),HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable int commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);
    }
}
