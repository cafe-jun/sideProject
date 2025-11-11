package com.example.sideproject.backend.service;


import com.example.sideproject.backend.domain.article.ArticleEntity;
import com.example.sideproject.backend.domain.type.SearchType;
import com.example.sideproject.backend.domain.user.UserEntity;
import com.example.sideproject.backend.dto.ArticleDto;
import com.example.sideproject.backend.dto.ArticleWithCommentsDto;
import com.example.sideproject.backend.dto.UserAccountDto;
import com.example.sideproject.backend.repository.ArticleRepository;
import com.example.sideproject.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable){
        if (searchKeyword == null || searchKeyword.isBlank()) {
           return articleRepository.findAll(pageable).map(ArticleDto::from);
        }

        return switch (searchType) {
            case TITLE -> articleRepository.findByTitleContaining(searchKeyword,pageable).map(ArticleDto::from);
            case CONTENT -> articleRepository.findByContentContaining(searchKeyword,pageable).map(ArticleDto::from);
            case USER_EMAIL -> articleRepository.findByUser_EmailContaining(searchKeyword,pageable).map(ArticleDto::from);
            case NICKNAME -> articleRepository.findByUser_NicknameContaining(searchKeyword,pageable).map(ArticleDto::from);
            case HASHTAG -> articleRepository.findByHashtag(searchKeyword,pageable).map(ArticleDto::from);
        };
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticleWithComments(Long articleId) {
        return articleRepository.findById(articleId)
                .map(ArticleWithCommentsDto::from)
                .orElseThrow(() -> new EntityNotFoundException("not found article data - "+ articleId));
    }

    @Transactional(readOnly = true)
    public ArticleDto getArticle(Long articleId) {
        return articleRepository.findById(articleId)
                .map(ArticleDto::from)
                .orElseThrow(() -> new EntityNotFoundException("not found article - articleId: {}"+articleId));
    }


    public void saveArticle(ArticleDto articleDto) {
        UserEntity userEntity = userRepository.getReferenceById(articleDto.userAccountDto().userId());
        articleRepository.save(articleDto.toEntity(userEntity));
    }

    public void updateArticle(Long articleId,ArticleDto dto) {
        try {
            ArticleEntity article = articleRepository.getReferenceById(articleId);
            UserEntity userEntity = userRepository.getReferenceById(dto.userAccountDto().userId());
            if (article.getUser().equals(userEntity)){
               if(dto.title() != null) { article.setTitle(dto.title()); }
               if(dto.content() != null) { article.setContent(dto.content()); }
               article.setHashtag(dto.hashtag());
            }
        } catch (EntityNotFoundException e) {
            log.warn("update article fail. {}",e.getLocalizedMessage());
        }
    }


    public void deleteArticle(Long articleId,Long userId) {
        articleRepository.deleteByUser_UserId(userId);
    }

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticlesViaHashtag (String hashtag, Pageable pageable) {
        if (hashtag == null || hashtag.isBlank()) {
            return Page.empty(pageable);
        }
        return articleRepository.findByHashtag(hashtag,pageable).map(ArticleDto::from);
    }

    public long getArticleCount() {
        return articleRepository.count();
    }

    public List<String> getHashtags() {
        return articleRepository.findAllDistinctHashtags();
    }

}
