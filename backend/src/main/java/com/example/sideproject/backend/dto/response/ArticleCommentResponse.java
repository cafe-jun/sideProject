package com.example.sideproject.backend.dto.response;

import com.example.sideproject.backend.dto.ArticleCommentDto;

import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long commentId,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname,
        String userId
) {
    public static ArticleCommentResponse of(Long commentId,String content,LocalDateTime createdAt,String email,String nickname,String userId) {
        return new ArticleCommentResponse(commentId,content,createdAt,email,nickname,userId);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = dto.userAccountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().email();
        }
        return new ArticleCommentResponse(
                dto.commentId(),
                dto.content(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname,
                dto.userAccountDto().email()
        );
    }
}
