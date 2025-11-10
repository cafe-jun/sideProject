package com.example.sideproject.backend.domain.article;


import com.example.sideproject.backend.domain.AuditingFieldEntity;
import com.example.sideproject.backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Getter
@ToString(callSuper = true)
@Table(name = "article_comment", indexes = {
       @Index(columnList = "created_at"),
       @Index(columnList = "created_by")
})
@Entity
public class ArticleCommentEntity extends AuditingFieldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @Setter
    @Column(nullable = false)
    private String content;


    protected ArticleCommentEntity() {}

    public ArticleCommentEntity(UserEntity user, ArticleEntity article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArticleCommentEntity that)) return false;
        return commentId != null && commentId.equals(that.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentId);
    }
}
