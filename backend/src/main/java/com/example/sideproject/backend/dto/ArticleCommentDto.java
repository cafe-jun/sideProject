package com.example.sideproject.backend.dto;

import com.example.sideproject.backend.domain.article.ArticleCommentEntity;

import java.time.LocalDateTime;

public record ArticleCommentDto (
        Long commentId,
        Long articleId,
        UserAccountDto userAccountDto,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleCommentDto of(Long commentId,
                                       Long articleId,
                                       UserAccountDto userAccountDto,
                                       String content,
                                       LocalDateTime createdAt,
                                       String createdBy,
                                       LocalDateTime modifiedAt,
                                       String modifiedBy) {

        return new ArticleCommentDto(commentId,articleId,userAccountDto,content,createdAt,createdBy,modifiedAt,modifiedBy);
    }

    public static ArticleCommentDto of(Long articleId,UserAccountDto userAccountDto,String content) {
        return new ArticleCommentDto(null,articleId,userAccountDto,content,null,null,null,null);
    }

    public static ArticleCommentDto from(ArticleCommentEntity entity) {
        return new ArticleCommentDto(
                entity.getCommentId(),
                entity.getArticle().getArticleId(),
                UserAccountDto.from(entity.getUser()),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
}
