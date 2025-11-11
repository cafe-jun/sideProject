package com.example.sideproject.backend.dto.response;

import com.example.sideproject.backend.dto.ArticleWithCommentsDto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsResponse(
        Long articleId,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname,
        Long userId,
        Set<ArticleCommentResponse> articleCommentResponses
) {
    public static ArticleWithCommentsResponse of (
            Long articleId,
            String title,
            String content,
            String hashtag,
            LocalDateTime createdAt,
            String email,
            String nickname,
            Long userId,
            Set<ArticleCommentResponse> articleCommentResponses
    ) {
        return new ArticleWithCommentsResponse(articleId,title,content,hashtag,createdAt,email,nickname,userId,articleCommentResponses);
    }

    public static ArticleWithCommentsResponse from (ArticleWithCommentsDto dto) {
        String nickname = dto.userAccountDto().nickname();
        if(nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().email();
        }
        return new ArticleWithCommentsResponse(
                dto.articleId(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname,
                dto.userAccountDto().userId(),
                dto.articleCommentDtos().stream()
                        .map(ArticleCommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }
}
