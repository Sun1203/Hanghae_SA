package com.tutorial.jwtsecurity.controller;


import com.tutorial.jwtsecurity.controller.dto.CommentRequestDto;
import com.tutorial.jwtsecurity.entity.Comment;
import com.tutorial.jwtsecurity.repository.CommentRepository;
import com.tutorial.jwtsecurity.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글작성
    @PostMapping("/api/auth/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    // 댓글 조회
    @GetMapping("/api/comment/{id}")
    public Optional<Comment> commentGetOne(@PathVariable Long id) {
        return commentService.commentGetOne(id);
    }

    // 댓글 수정
    @PutMapping("/api/auth/comment/{id}")
    public Comment commentUpdate(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.commentUpdateOne(id, requestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/api/auth/comment/{id}")
    public void commentDeleteOne(@PathVariable Long id) {
        commentService.commentDelete(id);
    }




}
