package com.athiramk.bookmark.domain;

import com.athiramk.bookmark.domain.model.BookmarkRequest;
import com.athiramk.bookmark.domain.model.BookmarkResponse;

class BookmarkMapper {

    static BookmarkResponse toBookmarkDTO(Bookmark bookmark) {
        if(bookmark == null)
            return null;
        return new BookmarkResponse(bookmark.getId(),
                bookmark.getTitle(),
                bookmark.getUrl(),
                bookmark.getCreatedAt());
    }

    public static Bookmark toBookmarkEntity(BookmarkRequest bookmarkRequest) {
        if(bookmarkRequest == null)
            return null;
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(bookmarkRequest.title());
        bookmark.setUrl(bookmarkRequest.url());
        return bookmark;
    }
}
