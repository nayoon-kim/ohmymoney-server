package com.najinji.ohmymoneyserver.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {

    GOOGLE("google"),
    KAKAO("kakao"),
    FACEBOOK("facebook");

    private final String accessType;
}
