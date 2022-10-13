package com.tutorial.jwtsecurity.controller.dto.postdto;

import com.tutorial.jwtsecurity.entity.Member;
import com.tutorial.jwtsecurity.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class PostReturnDto {
    private Long id;
    private String title;
    private String contents;
    private String nickname;


    public PostReturnDto(Post post) {
        this.nickname = post.getMember().getNickname();
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }


}
