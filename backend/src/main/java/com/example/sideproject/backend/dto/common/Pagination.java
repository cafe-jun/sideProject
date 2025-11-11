package com.example.sideproject.backend.dto.common;

import org.springframework.data.domain.Page;

import java.util.List;

public record Pagination(
        int page,
        int size,
        int totalPages,
        long totalElements,
        boolean first,
        boolean last,
        boolean hasNext,
        boolean hasPrevious,
        List<Integer> bar,
        List<SortInfo> sort
) {
    public static Pagination from(Page<?> page, List<Integer> bar) {
        return new Pagination(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious(),
                bar,
                page.getSort().stream()
                        .map(order -> new SortInfo(order.getProperty(), order.getDirection().name()))
                        .toList()
        );
    }
}
