package com.sparta.submit.service;


import com.sparta.submit.dto.BlogRequestDto;
import com.sparta.submit.entity.Blog;
import com.sparta.submit.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    // 전체 게시글 조회
    public List<Blog> getBlogs() throws SQLException {
        return blogRepository.findByOrderByCreatedAtDesc();
    }

    public Blog createBlog(BlogRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);

        return blog;
    }

    public Long update(Long id, BlogRequestDto requestDto) throws SQLException {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        blog.update(requestDto);

        return id;
    }

    public Blog getOne(Long id) throws SQLException {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        return blog;
    }

    public Long deleteOne(Long id) throws  SQLException {
        blogRepository.deleteById(id);

        return id;
    }

    public boolean pwConfirm(Long id, BlogRequestDto requestDto) throws  SQLException {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        if (blog.getPassword().equals(requestDto.getPassword())) return true;
        else return false;
    }



}
