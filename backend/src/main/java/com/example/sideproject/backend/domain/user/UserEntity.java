package com.example.sideproject.backend.domain.user;


import com.example.sideproject.backend.domain.AuditingField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Entity
@ToString
@Table(name = "user")
public class UserEntity extends AuditingField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name="username", unique = true)
    private String username;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "is_lock",nullable = false)
    private boolean isLock;

    @Column(name = "is_social", nullable = false)
    private boolean isSocial;

    @Enumerated(EnumType.STRING)
    @Column(name = "socialProvider", nullable = false)
    private SocialProviderType socialProviderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private UserRoleType roleType;

    protected UserEntity() {}

    public UserEntity(String userId,String email,String username,String password,boolean isLock,boolean isSocial,SocialProviderType socialProviderType,UserRoleType roleType) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isLock = isLock;
        this.isSocial = isSocial;
        this.socialProviderType = socialProviderType;
        this.roleType = roleType;
    }

    public static UserEntity of(String userId,String email,String username,String password,boolean isLock,boolean isSocial,SocialProviderType socialProviderType,UserRoleType roleType) {
        return new  UserEntity(userId, email, username, password, isLock, isSocial, socialProviderType, roleType);
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
