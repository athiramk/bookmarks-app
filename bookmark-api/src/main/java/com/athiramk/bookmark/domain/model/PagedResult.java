package com.athiramk.bookmark.domain.model;

import org.springframework.data.domain.Page;

import java.util.List;

public record PagedResult<T>(
        List<T> data,
        long totalElements,
        int currentPage,
        int totalPages,
        boolean isFirst,
        boolean isLast,
        boolean hasNext,
        boolean hasPrevious) {

    public static <E> PagedResult<E> from(Page<E> page) {
        return new PagedResult<>(
                page.getContent(),
                page.getTotalElements(),
                page.getNumber() + 1, // Spring pages are 0-indexed
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious()
        );
    }
}