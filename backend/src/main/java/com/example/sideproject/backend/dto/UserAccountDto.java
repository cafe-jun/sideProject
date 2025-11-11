package com.example.sideproject.backend.dto;

import com.example.sideproject.backend.domain.user.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserAccountDto(
        Long userId,
        String email,
        String password,
        String nickname,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserEntity of(Long userId, String email, String password, String nickname, String createdBy, String modifiedBy) {
        return UserEntity.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .build();

    }

    public static UserAccountDto from(UserEntity entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

}