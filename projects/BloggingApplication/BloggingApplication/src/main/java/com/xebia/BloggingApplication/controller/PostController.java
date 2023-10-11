package com.xebia.BloggingApplication.controller;

import com.xebia.BloggingApplication.entites.Posts;
import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.PostDto;
import com.xebia.BloggingApplication.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable int userId,@PathVariable int categoryId){
        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int categoryId){
        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int userId){
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> posts = this.postService.readAllPosts();
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable int postId){
        PostDto post = this.postService.readPosts(postId);
        return new ResponseEntity<PostDto>(post,HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDto> deletePosts(@PathVariable int postId){
        this.postService.deletePost(postId);
        return new ResponseEntity(new ApiResponse("Post Deleted Successfully",true),HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable int postId){
        this.postService.updatePost(postDto,postId);
        return new ResponseEntity(new ApiResponse("Post Updated Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchALLPosts(@PathVariable("keyword") String keyword){
        List<PostDto> postDto = this.postService.searchPosts(keyword);
        return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.OK);
    }



}
