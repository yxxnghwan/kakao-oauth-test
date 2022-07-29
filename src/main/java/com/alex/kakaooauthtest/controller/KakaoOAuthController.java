package com.alex.kakaooauthtest.controller;

import com.alex.kakaooauthtest.service.MemberService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class KakaoOAuthController {

    @Value("${kakaoRestApiKey}")
    private String kakaoKey;

    private final MemberService memberService;

    @GetMapping("/requestKakaoLogin")
    public ModelAndView requestKakaoLogin() {
        final Map<String, Object> model = new HashMap<>();
        model.put("kakaoKey", kakaoKey);
        return new ModelAndView("requestKakaoLogin", model);
    }

    @GetMapping("/receiveToken")
    public ModelAndView receiveToken(@Param("code") String code, @Param("state") String state) {
        final Map<String, Object> model = new HashMap<>();
        model.put("code", code);
        model.put("kakaoKey", kakaoKey);
        model.put("state", state);
        return new ModelAndView("receiveToken", model);
    }

    @PostMapping("/member")
    @ResponseBody
    public ResponseEntity<MemberDto> joinMember(@RequestBody SignInDto signInDto) {
        System.out.println(signInDto.getOauthId() + signInDto.getUsername() + signInDto.getOauthType());
        final MemberDto memberDto = memberService.joinMember(signInDto);
        return ResponseEntity.ok(memberDto);
    }
}
