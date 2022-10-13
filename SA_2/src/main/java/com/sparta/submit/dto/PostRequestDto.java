package com.sparta.submit.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class PostRequestDto {

    // ㅈㅔ목
    String title;
    // 작성자
    String username;
    // 내용
    String contents;
    // 비밀번호
    String password;

}
