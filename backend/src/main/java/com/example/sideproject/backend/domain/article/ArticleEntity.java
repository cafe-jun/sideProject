package com.example.sideproject.backend.domain.article;

import com.example.sideproject.backend.domain.AuditingFieldEntity;
import com.example.sideproject.backend.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString(callSuper = true)
@Table(name = "article", indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "created_at"),
        @Index(columnList = "created_by")
})
@Entity
public class ArticleEntity extends AuditingFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    @Column(nullable = true, name = "hashtag")
    private String hashtag;


    @ToString.Exclude
//    @OrderBy("article.createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<ArticleCommentEntity> articleComments = new LinkedHashSet<ArticleCommentEntity>();

    protected ArticleEntity() {}

    private ArticleEntity(UserEntity user, String title, String content, String hashtag) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static ArticleEntity of(UserEntity user, String title, String content, String hashTag) {
        return new ArticleEntity(user, title, content, hashTag);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArticleEntity article)) return false;
        return articleId != null && articleId.equals(article.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId);
    }
}
