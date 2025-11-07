package com.example.sideproject.backend.domain.user;

public enum SocialProviderType {
    NAVER("네이버"),
    GOOGLE("구글");

    private String description;

    SocialProviderType(String description) {
        this.description = description;
    }
}
