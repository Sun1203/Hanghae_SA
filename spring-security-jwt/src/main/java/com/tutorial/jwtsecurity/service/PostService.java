package com.tutorial.jwtsecurity.service;


import com.tutorial.jwtsecurity.controller.dto.postdto.PostGetAllReturnDto;
import com.tutorial.jwtsecurity.controller.dto.postdto.PostRequestDto;
import com.tutorial.jwtsecurity.controller.dto.postdto.PostReturnDto;
import com.tutorial.jwtsecurity.entity.Member;
import com.tutorial.jwtsecurity.entity.Post;
import com.tutorial.jwtsecurity.repository.MemberRepository;
import com.tutorial.jwtsecurity.repository.PostRepository;
import com.tutorial.jwtsecurity.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @Autowired
    public PostService(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    public PostReturnDto createPost(PostRequestDto postRequestDto) {

        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new IllegalArgumentException("아이디를 찾을 수 없습니다."));
        Post post = new Post(postRequestDto, member);
        postRepository.save(post);

        return new PostReturnDto(post);
    }

    public List<PostGetAllReturnDto> getAllPost() {

        List<Post> post = postRepository.findAll();

        List<PostGetAllReturnDto> postList = new ArrayList<>();

        for (int i=0;i<post.size();i++){
            PostGetAllReturnDto postGetAllReturnDto = new PostGetAllReturnDto(post.get(i).getTitle(),
                                                            post.get(i).getContents(),
                                                            post.get(i).getMember().getId(),
                                                            post.get(i).getId(),
                                                            post.get(i).getMember().getNickname());
            postList.add(postGetAllReturnDto);
        }
        return postList;
    }

    public Optional<Post> getOnePost(Long id) {

        Optional<Post> post = postRepository.findById(id);

        return post;
    }

    public Post updatePost(PostRequestDto requestDto, Long id) {

        Post post = postRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을수 없습니다"));
        post.updatePost(requestDto);
        postRepository.save(post);

        return post;
    }

    public void deleteOne(Long id) {
        Long currId = SecurityUtil.getCurrentMemberId();

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을수 없습니다"));
        if (post.getMember().getId().equals(currId)) postRepository.deleteById(id);
    }

}
