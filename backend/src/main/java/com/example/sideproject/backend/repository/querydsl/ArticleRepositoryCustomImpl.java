package com.example.sideproject.backend.repository.querydsl;

import com.example.sideproject.backend.domain.article.ArticleEntity;
import com.example.sideproject.backend.domain.article.QArticleEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryCustomImpl() {
        super(ArticleEntity.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {
        QArticleEntity article = QArticleEntity.articleEntity;
        return from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }
}
