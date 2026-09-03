package com.athiramk.bookmark.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }


    @Transactional(readOnly = true)
    public List<Bookmark> getBookmarks() {
        return bookmarkRepository.findAll();
    }
}
