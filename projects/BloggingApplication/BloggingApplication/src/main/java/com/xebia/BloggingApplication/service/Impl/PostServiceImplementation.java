package com.xebia.BloggingApplication.service.Impl;

import com.xebia.BloggingApplication.entites.Category;
import com.xebia.BloggingApplication.entites.Posts;
import com.xebia.BloggingApplication.entites.User;
import com.xebia.BloggingApplication.exceptions.ResouceNotFoundException;
import com.xebia.BloggingApplication.payloads.PostDto;
import com.xebia.BloggingApplication.repositories.CategoryRepository;
import com.xebia.BloggingApplication.repositories.PostRepository;
import com.xebia.BloggingApplication.repositories.UserRepository;
import com.xebia.BloggingApplication.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto,int userId,int categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("user","Id",userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResouceNotFoundException("Category","Id",categoryId));

        Posts posts = modelMapper.map(postDto,Posts.class);
        posts.setImageName("default.png");
        posts.setDateTime(new Date());
        posts.setUser(user);
        posts.setCategory(category);

        Posts newPost = postRepository.save(posts);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, int postId) {
        Posts post = this.postRepository.findById(postId).orElseThrow(()->new ResouceNotFoundException("Post","Id",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Posts updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(int postId) {
        Posts post = this.postRepository.findById(postId).orElseThrow(()->new ResouceNotFoundException("Post","Id",postId));
        this.postRepository.delete(post);
    }

    @Override
    public List<PostDto> readAllPosts() {
        List<Posts> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto readPosts(int postId) {
        Posts post = this.postRepository.findById(postId).orElseThrow(()->new ResouceNotFoundException("Post","Id",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(int categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResouceNotFoundException("category","Id",categoryId));

        List<Posts> posts = this.postRepository.findAByCategory(category);

        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser (int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("User","Id",userId));
        List<Posts> posts = this.postRepository.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Posts> posts = this.postRepository.findByTitleContaining("%"+keyword+"%");

        List<PostDto> postDtos =posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList()) ;
        return postDtos;
    }
}
