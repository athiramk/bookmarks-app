package com.athiramk.bookmark.api;

import com.athiramk.bookmark.domain.model.BookmarkRequest;
import com.athiramk.bookmark.domain.model.BookmarkResponse;
import com.athiramk.bookmark.domain.BookmarkService;
import com.athiramk.bookmark.domain.model.PagedResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    public PagedResult<BookmarkResponse> getBookmarks(@RequestParam(name="page", defaultValue = "1")Integer page,
                                                      @RequestParam(defaultValue = "") String query) {
        if(query == null || query.trim().isEmpty()) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkResponse addBookmark(@RequestBody BookmarkRequest bookmarkRequest) {
        return bookmarkService.addBookmark(bookmarkRequest);
    }

}
