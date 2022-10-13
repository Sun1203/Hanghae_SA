package com.tutorial.jwtsecurity.controller;


import com.tutorial.jwtsecurity.controller.dto.postdto.PostGetAllReturnDto;
import com.tutorial.jwtsecurity.controller.dto.postdto.PostRequestDto;
import com.tutorial.jwtsecurity.controller.dto.postdto.PostReturnDto;
import com.tutorial.jwtsecurity.entity.Post;
import com.tutorial.jwtsecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/auth/post")
    public PostReturnDto createPost(@RequestBody PostRequestDto postRequestDto) {

        return postService.createPost(postRequestDto);
    }

    @GetMapping("/api/post")
    public List<PostGetAllReturnDto> postGetAll() {
        return postService.getAllPost();
    }

    @GetMapping("/api/post/{id}")
    public Optional<Post> postGetOne(@PathVariable Long id) {
        return postService.getOnePost(id);
    }

    @PutMapping("/api/auth/post/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(requestDto, id);
    }

    @DeleteMapping("/api/auth/post/{id}")
    public void deleteOne(@PathVariable Long id) {
        postService.deleteOne(id);
    }

}
