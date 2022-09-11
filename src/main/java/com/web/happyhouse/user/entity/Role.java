package com.web.happyhouse.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER", "일반 사용자"),
    AGENT("ROLE_AGENT", "부동산 중개인"),
    ADMIN("ROLE_ADMIN", "관리자");


    private final String key;
    private final String title;
}
