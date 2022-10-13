package com.tutorial.jwtsecurity.service;

import com.tutorial.jwtsecurity.controller.dto.CommentRequestDto;
import com.tutorial.jwtsecurity.entity.Comment;
import com.tutorial.jwtsecurity.entity.Member;
import com.tutorial.jwtsecurity.entity.Post;
import com.tutorial.jwtsecurity.repository.CommentRepository;
import com.tutorial.jwtsecurity.repository.MemberRepository;
import com.tutorial.jwtsecurity.repository.PostRepository;
import com.tutorial.jwtsecurity.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(CommentRequestDto requestDto) {
        Long curId = SecurityUtil.getCurrentMemberId();

        Member member = memberRepository.findById(curId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을수 없습니다"));

        Post post = postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을수 없습니다"));

        Comment comment = new Comment(requestDto, member, post);

        commentRepository.save(comment);

        return comment;
    }

    public Optional<Comment> commentGetOne(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        return comment;
    }

    public Comment commentUpdateOne(Long id, CommentRequestDto requestDto) {

        Long curId = SecurityUtil.getCurrentMemberId();

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾지 못했습니다"));

        comment.updateComment(requestDto);
        if (curId.equals(comment.getMember().getId())) commentRepository.save(comment);
        System.out.println(comment.getMember().getId());
        return comment;
    }

    public void commentDelete(Long id) {
        Long curId = SecurityUtil.getCurrentMemberId();

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾지 못했습니다"));

        if (curId.equals(comment.getMember().getId())) commentRepository.deleteById(id);
    }

}
