package com.athiramk.bookmark.domain.model;

import java.time.Instant;

public record BookmarkResponse(
         Long id,
         String title,
         String url,
         Instant createdAt
) { }