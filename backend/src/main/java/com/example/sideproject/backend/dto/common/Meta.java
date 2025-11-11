package com.example.sideproject.backend.dto.common;

import java.time.Instant;
import java.util.UUID;

public record Meta(String requestId, Instant timestamp) {
    public static Meta defaultNow() {
        return new Meta(UUID.randomUUID().toString(), Instant.now());
    }
}