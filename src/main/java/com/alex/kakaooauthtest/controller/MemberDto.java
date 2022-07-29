package com.alex.kakaooauthtest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private Long oauthId;
    private String username;
    private String oAuthType;

}
