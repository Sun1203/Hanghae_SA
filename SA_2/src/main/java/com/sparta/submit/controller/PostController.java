package com.sparta.submit.controller;


import com.sparta.submit.dto.PostRequestDto;
import com.sparta.submit.entity.Post;
import com.sparta.submit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PostController {


    private final PostService blogService;

    @Autowired
    public PostController(PostService blogService) {
        this.blogService = blogService;
    }

    // 신규 상품 등록
    @PostMapping("/api/blogs")
    public Post createProduct(@RequestBody PostRequestDto requestDto) throws SQLException {

        Post blog = blogService.createBlog(requestDto);

        // 응답 보내기
        return blog;
    }


    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody PostRequestDto requestDto) throws SQLException {

        return blogService.update(id, requestDto);
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/blogs")
    public List<Post> getBlogs() throws SQLException {
        List<Post> blogs = blogService.getBlogs();

        // 응답 보내기
        return blogs;
    }

    @GetMapping("/api/blogs/{id}")
    public Post getBlogOne(@PathVariable Long id) throws SQLException {
        Post blogs = blogService.getOne(id);
        return blogs;
    }

    @DeleteMapping("api/blogs/{id}")
    public Long deleteOne(@PathVariable Long id) throws SQLException {
        return blogService.deleteOne(id);
    }

    @PostMapping("api/blogs/{id}")
    public boolean pwConfirm(@PathVariable Long id, @RequestBody PostRequestDto requestDto) throws SQLException {

        return blogService.pwConfirm(id , requestDto);

    }

    // 진짜 업데이트
    @PatchMapping("api/blogs/{id}")
    public Long update2(@PathVariable Long id, @RequestBody PostRequestDto requestDto) throws SQLException {

        return blogService.patchUpdate(id, requestDto);
    }






}
