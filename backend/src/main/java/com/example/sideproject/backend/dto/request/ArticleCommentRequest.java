package com.example.sideproject.backend.dto.request;

import com.example.sideproject.backend.dto.ArticleCommentDto;
import com.example.sideproject.backend.dto.UserAccountDto;

public record ArticleCommentRequest(
        Long articleId,
        String content
) {
    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto dto) {
        return ArticleCommentDto.of(articleId,dto,content);
    }
}
