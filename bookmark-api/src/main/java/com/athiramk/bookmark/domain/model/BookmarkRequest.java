package com.athiramk.bookmark.domain.model;

import java.time.Instant;

public record BookmarkRequest(
        String title,
        String url,
        Instant createdAt
) {
}
