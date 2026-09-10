package com.athiramk.bookmark.domain;

import com.athiramk.bookmark.domain.model.BookmarkRequest;
import com.athiramk.bookmark.domain.model.BookmarkResponse;
import com.athiramk.bookmark.domain.model.PagedResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }


    @Transactional(readOnly = true)
    public PagedResult<BookmarkResponse> getBookmarks(int page) {
        int pageNo = page<1 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNo,10, Sort.Direction.DESC, "createdAt");


        Page<BookmarkResponse> bookmarkPage= bookmarkRepository.findAll(pageable)
                .map(BookmarkMapper::toBookmarkDTO);

         return PagedResult.from(bookmarkPage);
    }

    public BookmarkResponse addBookmark(BookmarkRequest bookmarkRequest) {
        Bookmark bookmark = BookmarkMapper.toBookmarkEntity(bookmarkRequest);
        bookmark.setCreatedAt(Instant.now());
        Bookmark bookmarkSaved = bookmarkRepository.save(bookmark);
        return BookmarkMapper.toBookmarkDTO(bookmarkSaved);
    }

    @Transactional(readOnly = true)
    public PagedResult<BookmarkResponse> searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");

        Page<BookmarkResponse> bookmarkPage = bookmarkRepository.findByTitleContainsIgnoreCase(query,pageable)
                .map(BookmarkMapper::toBookmarkDTO);

        return PagedResult.from(bookmarkPage);

    }
}
