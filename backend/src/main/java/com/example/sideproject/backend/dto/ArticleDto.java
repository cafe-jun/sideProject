package com.example.sideproject.backend.dto;

import com.example.sideproject.backend.domain.article.ArticleEntity;
import com.example.sideproject.backend.domain.user.UserEntity;
import com.example.sideproject.backend.dto.UserAccountDto;

import java.time.LocalDateTime;

public record ArticleDto (
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleDto of (UserAccountDto userAccountDto,String title, String content,String hashtag) {
        return new ArticleDto(null,userAccountDto,title,content,hashtag,null,null, null,null);
    }
    public static ArticleDto of(Long id, UserAccountDto userAccountDto, String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, userAccountDto, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleDto from(ArticleEntity entity) {
        return new ArticleDto(
                entity.getArticleId(),
                UserAccountDto.from(entity.getUser()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
    public ArticleEntity toEntity(UserEntity userAccount) {
        return ArticleEntity.of(
                userAccount,
                title,
                content,
                hashtag
        );
    }
}