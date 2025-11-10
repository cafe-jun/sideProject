package com.example.sideproject.backend.repository;

import com.example.sideproject.backend.domain.article.ArticleCommentEntity;
import com.example.sideproject.backend.domain.article.QArticleCommentEntity;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleCommentEntity,Long>,
    QuerydslPredicateExecutor<ArticleCommentEntity>,
    QuerydslBinderCustomizer<QArticleCommentEntity>
{

    List<ArticleCommentEntity> findByArticle_articleId(Long articleId);

    void deleteByCommentIdAndUser_Email(Long commentId,String email);

    @Override
    default void customize(QuerydslBindings bindings, QArticleCommentEntity root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content,root.createdAt,root.createdBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    };
}
