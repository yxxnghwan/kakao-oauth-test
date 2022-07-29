package com.alex.kakaooauthtest.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long oauthId;

    private String username;

    @Enumerated(EnumType.STRING)
    private OAuthType oAuthType;

    public Member(final Long oauthId, final String username, final OAuthType oAuthType) {
        this.oauthId = oauthId;
        this.username = username;
        this.oAuthType = oAuthType;
    }
}
