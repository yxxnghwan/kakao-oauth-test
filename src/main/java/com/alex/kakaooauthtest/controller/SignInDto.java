package com.alex.kakaooauthtest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignInDto {

    private Long oauthId;

    private String username;

    private String oauthType;
}
