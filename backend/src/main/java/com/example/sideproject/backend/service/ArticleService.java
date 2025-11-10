package com.example.sideproject.backend.service;


import com.example.sideproject.backend.domain.article.ArticleEntity;
import com.example.sideproject.backend.domain.type.SearchType;
import com.example.sideproject.backend.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleEntity> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable){
        if (searchKeyword == null || searchKeyword.isBlank()) {
           return articleRepository.findAll(pageable).map();
        }

        return switch (searchType) {
            case TITLE -> articleRepository.findByTitleContaining(searchKeyword,pageable);
            case CONTENT -> articleRepository.findByContentContaining(searchKeyword,pageable);
            case USER_EMAIL -> articleRepository.findByUser_EmailContaining(searchKeyword,pageable);
            case NICKNAME -> articleRepository.findByUser_NicknameContaining(searchKeyword,pageable);
            case HASHTAG -> articleRepository.findByHashtag(searchKeyword,pageable);
        };
    }

}
