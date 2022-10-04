package com.sparta.submit.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BlogRequestDto {

    // ㅈㅔ목
    String title;
    // 작성자
    String username;
    // 내용
    String contents;
    // 비밀번호
    String password;

}
