package com.tutorial.jwtsecurity.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class CommentRequestDto {
    private Long postId;
    private String comment;
}
