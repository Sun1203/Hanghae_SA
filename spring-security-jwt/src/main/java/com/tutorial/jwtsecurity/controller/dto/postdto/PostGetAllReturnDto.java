package com.tutorial.jwtsecurity.controller.dto.postdto;


import com.tutorial.jwtsecurity.entity.Member;
import com.tutorial.jwtsecurity.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.sound.midi.MetaMessage;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class PostGetAllReturnDto {

    private String title;
    private String contents;
    private Long memberId;
    private Long postId;
    private String memberNickname;
}
