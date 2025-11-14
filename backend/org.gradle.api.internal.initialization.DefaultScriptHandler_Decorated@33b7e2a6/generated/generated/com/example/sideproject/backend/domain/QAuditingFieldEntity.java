package com.example.sideproject.backend.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingFieldEntity is a Querydsl query type for AuditingFieldEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingFieldEntity extends EntityPathBase<AuditingFieldEntity> {

    private static final long serialVersionUID = 356059075L;

    public static final QAuditingFieldEntity auditingFieldEntity = new QAuditingFieldEntity("auditingFieldEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public QAuditingFieldEntity(String variable) {
        super(AuditingFieldEntity.class, forVariable(variable));
    }

    public QAuditingFieldEntity(Path<? extends AuditingFieldEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingFieldEntity(PathMetadata metadata) {
        super(AuditingFieldEntity.class, metadata);
    }

}

