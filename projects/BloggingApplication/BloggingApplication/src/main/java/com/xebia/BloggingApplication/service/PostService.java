package com.xebia.BloggingApplication.service;

import com.xebia.BloggingApplication.entites.Posts;
import com.xebia.BloggingApplication.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,int userId,int categoryId);
    //update
    PostDto updatePost(PostDto postDto,int postId);
    //delete
    void deletePost(int postId);
    //readAll
    List<PostDto> readAllPosts();
    //read
    PostDto readPosts(int postId);


    //get All PostBy Category
    List<PostDto> getPostByCategory(int categoryId);

    //get All PostBy Users
    List<PostDto> getPostsByUser(int userId);

    List<PostDto> searchPosts(String keyword);




}
