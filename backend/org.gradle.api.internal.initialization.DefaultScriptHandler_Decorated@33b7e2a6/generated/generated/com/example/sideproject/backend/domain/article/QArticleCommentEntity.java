package com.example.sideproject.backend.domain.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleCommentEntity is a Querydsl query type for ArticleCommentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleCommentEntity extends EntityPathBase<ArticleCommentEntity> {

    private static final long serialVersionUID = -1286122633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleCommentEntity articleCommentEntity = new QArticleCommentEntity("articleCommentEntity");

    public final com.example.sideproject.backend.domain.QAuditingFieldEntity _super = new com.example.sideproject.backend.domain.QAuditingFieldEntity(this);

    public final QArticleEntity article;

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final com.example.sideproject.backend.domain.user.QUserEntity user;

    public QArticleCommentEntity(String variable) {
        this(ArticleCommentEntity.class, forVariable(variable), INITS);
    }

    public QArticleCommentEntity(Path<? extends ArticleCommentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleCommentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleCommentEntity(PathMetadata metadata, PathInits inits) {
        this(ArticleCommentEntity.class, metadata, inits);
    }

    public QArticleCommentEntity(Class<? extends ArticleCommentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticleEntity(forProperty("article"), inits.get("article")) : null;
        this.user = inits.isInitialized("user") ? new com.example.sideproject.backend.domain.user.QUserEntity(forProperty("user")) : null;
    }

}

