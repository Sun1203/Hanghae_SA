package com.tutorial.jwtsecurity.controller.dto.postdto;


import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class PostRequestDto {
    private String title;
    private String contents;

    public PostRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
