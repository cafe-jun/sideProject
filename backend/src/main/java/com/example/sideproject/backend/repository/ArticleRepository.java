package com.example.sideproject.backend.repository;


import com.example.sideproject.backend.domain.article.ArticleEntity;
import com.example.sideproject.backend.domain.article.QArticleEntity;
import com.example.sideproject.backend.repository.querydsl.ArticleRepositoryCustom;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Long>,
                                           ArticleRepositoryCustom,
                                           QuerydslPredicateExecutor<ArticleEntity>,
                                           QuerydslBinderCustomizer<QArticleEntity> {

    Page<ArticleEntity> findByTitleContaining(String title,Pageable pageable);
    Page<ArticleEntity> findByContentContaining(String content,Pageable pageable);
    Page<ArticleEntity> findByUser_EmailContaining(String email,Pageable pageable);
    Page<ArticleEntity> findByUser_NicknameContaining(String nickname,Pageable pageable);
    Page<ArticleEntity> findByHashtag(String hashtag,Pageable pageable);

    void deleteByUser_UserId(Long userId);


    @Override
    default void customize(QuerydslBindings bindings, QArticleEntity root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title,root.content,root.hashtag,root.createdAt,root.createdBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    };
}
