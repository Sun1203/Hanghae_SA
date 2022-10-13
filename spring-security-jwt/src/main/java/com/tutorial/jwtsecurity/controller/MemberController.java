package com.tutorial.jwtsecurity.controller;


import com.tutorial.jwtsecurity.controller.dto.memberdto.MemberRequestDto;
import com.tutorial.jwtsecurity.controller.dto.memberdto.MemberResponseDto;
import com.tutorial.jwtsecurity.controller.dto.TokenRequestDto;
import com.tutorial.jwtsecurity.controller.dto.TokenDto;
import com.tutorial.jwtsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.signup(memberRequestDto));
    }

    @PostMapping("/member/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto,
                                          HttpServletResponse response) {
        response.setHeader("refreshToken", "실제토큰");
        return ResponseEntity.ok(memberService.login(memberRequestDto));
    }

    @PostMapping("/member/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(memberService.reissue(tokenRequestDto));
    }
}
