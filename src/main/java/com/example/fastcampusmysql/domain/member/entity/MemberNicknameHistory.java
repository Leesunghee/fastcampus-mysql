package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class MemberNicknameHistory {

    private final Long id;
    private final LocalDateTime createdAt;
    private final String nickname;
    private final Long memberId;

    @Builder
    public MemberNicknameHistory(Long id, LocalDateTime createdAt, String nickname, Long memberId) {
        this.id = id;
        this.nickname = Objects.requireNonNull(nickname);
        this.memberId = Objects.requireNonNull(memberId);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
