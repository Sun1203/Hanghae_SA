package com.sparta.submit.service;


import com.sparta.submit.dto.PostRequestDto;
import com.sparta.submit.entity.Post;
import com.sparta.submit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository blogRepository;

    @Autowired
    public PostService(PostRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    // 전체 게시글 조회
    public List<Post> getBlogs() throws SQLException {
        return blogRepository.findByOrderByCreatedAtDesc();
    }

    public Long update(Long id, PostRequestDto requestDto) throws SQLException {
        Post blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        blog.update(requestDto);
        blogRepository.save(blog);
        return id;
    }

    public Post createBlog(PostRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
//        System.out.println(requestDto.getContents().getClass().getName());
//        System.out.println("========================");
        Post blog = new Post(requestDto);
//        System.out.println(blog.getContents());
//        System.out.println(blog.getPassword());
//        System.out.println(blog.getTitle());
//        System.out.println(blog.getUsername());
        blogRepository.save(blog);

        return blog;
    }

    public Post getOne(Long id) throws SQLException {
        Post blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        return blog;
    }

    public Long deleteOne(Long id) throws  SQLException {
        blogRepository.deleteById(id);

        return id;
    }

    public boolean pwConfirm(Long id, PostRequestDto requestDto) throws  SQLException {
        Post blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        if (blog.getPassword().equals(requestDto.getPassword())) return true;
        else return false;
    }

    public Long patchUpdate(Long id, PostRequestDto requestDto) throws SQLException {

        Post blog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        List<PostRequestDto> list = new ArrayList<>();
        list.add(requestDto);


        System.out.println(list.get(0).getTitle().getClass().getName());
        System.out.println(list.get(0).getContents() == null);

        for (int i=0;i< list.size();i++) {
            if (list.get(i).getContents() != null) blog.setContents(list.get(i).getContents());
            if (list.get(i).getUsername() != null) blog.setUsername(list.get(i).getUsername());
            if (list.get(i).getPassword() != null) blog.setPassword(list.get(i).getPassword());
            if (list.get(i).getTitle() != null) blog.setTitle(list.get(i).getTitle());
        }

        blogRepository.save(blog);

        return id;
    }

}
