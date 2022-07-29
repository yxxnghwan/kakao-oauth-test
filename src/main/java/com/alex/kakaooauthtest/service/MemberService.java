package com.alex.kakaooauthtest.service;

import com.alex.kakaooauthtest.controller.MemberDto;
import com.alex.kakaooauthtest.controller.SignInDto;
import com.alex.kakaooauthtest.domain.Member;
import com.alex.kakaooauthtest.domain.OAuthType;
import com.alex.kakaooauthtest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto joinMember(final SignInDto signInDto) {
        final Member savedMember = memberRepository.save(
                new Member(
                        signInDto.getOauthId(),
                        signInDto.getUsername(),
                        OAuthType.valueOf(signInDto.getOauthType())
                )
        );

        return new MemberDto(
                savedMember.getId(),
                savedMember.getOauthId(),
                savedMember.getUsername(),
                savedMember.getOAuthType().name()
        );
    }
}
