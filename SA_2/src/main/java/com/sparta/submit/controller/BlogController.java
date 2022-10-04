package com.sparta.submit.controller;


import com.sparta.submit.dto.BlogRequestDto;
import com.sparta.submit.entity.Blog;
import com.sparta.submit.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BlogController {


    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // 신규 상품 등록
    @PostMapping("/api/blogs")
    public Blog createProduct(@RequestBody BlogRequestDto requestDto) throws SQLException {
        Blog blog = blogService.createBlog(requestDto);

        // 응답 보내기
        return blog;
    }

    // 설정 가격 변경
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) throws SQLException {
        return blogService.update(id, requestDto);
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() throws SQLException {
        List<Blog> blogs = blogService.getBlogs();

        // 응답 보내기
        return blogs;
    }

    @GetMapping("/api/blogs/{id}")
    public Blog getBlogOne(@PathVariable Long id) throws SQLException {
        Blog blogs = blogService.getOne(id);
        return blogs;
    }

    @DeleteMapping("api/blogs/{id}")
    public Long deleteOne(@PathVariable Long id) throws SQLException {
        return blogService.deleteOne(id);
    }

    @PostMapping("api/blogs/{id}")
    public boolean pwConfirm(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) throws SQLException {

        return blogService.pwConfirm(id , requestDto);

    }





}
