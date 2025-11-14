package com.example.sideproject.backend.domain.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = -997699282L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final com.example.sideproject.backend.domain.QAuditingFieldEntity _super = new com.example.sideproject.backend.domain.QAuditingFieldEntity(this);

    public final SetPath<ArticleCommentEntity, QArticleCommentEntity> articleComments = this.<ArticleCommentEntity, QArticleCommentEntity>createSet("articleComments", ArticleCommentEntity.class, QArticleCommentEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath hashtag = createString("hashtag");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath title = createString("title");

    public final com.example.sideproject.backend.domain.user.QUserEntity user;

    public QArticleEntity(String variable) {
        this(ArticleEntity.class, forVariable(variable), INITS);
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleEntity(PathMetadata metadata, PathInits inits) {
        this(ArticleEntity.class, metadata, inits);
    }

    public QArticleEntity(Class<? extends ArticleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.sideproject.backend.domain.user.QUserEntity(forProperty("user")) : null;
    }

}

