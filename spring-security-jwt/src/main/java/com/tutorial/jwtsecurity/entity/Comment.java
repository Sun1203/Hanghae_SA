package com.tutorial.jwtsecurity.entity;


import com.tutorial.jwtsecurity.controller.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Post post;


    public Comment(CommentRequestDto commentRequestDto, Member member, Post post) {
        this.comment = commentRequestDto.getComment();
        this.member = member;
        this.post = post;
    }

    public void updateComment(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }
}
