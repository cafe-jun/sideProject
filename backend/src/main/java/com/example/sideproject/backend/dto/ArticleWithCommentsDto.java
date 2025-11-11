package com.example.sideproject.backend.dto;

import com.example.sideproject.backend.domain.article.ArticleEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsDto(
        Long articleId,
        UserAccountDto userAccountDto,
        Set<ArticleCommentDto> articleCommentDtos,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleWithCommentsDto of(Long articleId,
                                            UserAccountDto userAccountDto,
                                            Set<ArticleCommentDto> articleCommentDtos,
                                            String title,
                                            String content,
                                            String hashtag,
                                            LocalDateTime createdAt,
                                            String createdBy,
                                            LocalDateTime modifiedAt,
                                            String modifiedBy ) {
        return new ArticleWithCommentsDto(articleId,userAccountDto,articleCommentDtos,title,content,hashtag,createdAt,createdBy,modifiedAt,modifiedBy);

    }

    public static ArticleWithCommentsDto from(ArticleEntity entity) {
        return new ArticleWithCommentsDto(
                entity.getArticleId(),
                UserAccountDto.from(entity.getUser()),
                entity.getArticleComments()
                        .stream().map(ArticleCommentDto::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
}
