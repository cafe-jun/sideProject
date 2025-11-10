package com.example.sideproject.backend.domain.user;


import com.example.sideproject.backend.domain.AuditingFieldEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(name = "users")
@Entity
public class UserEntity extends AuditingFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name="nickname", unique = true)
    private String nickname;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "is_lock",nullable = false)
    private boolean isLock;

    @Column(name = "is_social", nullable = false)
    private boolean isSocial;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_provider", nullable = false)
    private SocialProviderType socialProviderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private UserRoleType roleType;

    protected UserEntity() {}

    @Builder
    public UserEntity(Long userId,String email,String nickname,String password,boolean isLock,boolean isSocial,SocialProviderType socialProviderType,UserRoleType roleType) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.isLock = isLock;
        this.isSocial = isSocial;
        this.socialProviderType = socialProviderType;
        this.roleType = roleType;
    }

    public static UserEntity of(Long userId,String email,String nickname,String password,boolean isLock,boolean isSocial,SocialProviderType socialProviderType,UserRoleType roleType) {
        return new  UserEntity(userId, email, nickname, password, isLock, isSocial, socialProviderType, roleType);
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj) return true;
        if(!(obj instanceof UserEntity that)) return false;
        return userId != null && userId.equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
