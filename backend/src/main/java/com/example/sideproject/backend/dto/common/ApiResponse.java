package com.example.sideproject.backend.dto.common;

public record ApiResponse<T>(
        T data,
        Pagination pagination,
        Meta meta
) {
    public static <T> ApiResponse<T> of(T data, Pagination pagination) {
        return new ApiResponse<>(data, pagination, Meta.defaultNow());
    }
}
