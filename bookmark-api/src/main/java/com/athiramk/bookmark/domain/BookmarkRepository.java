package com.athiramk.bookmark.domain;

import com.athiramk.bookmark.domain.model.BookmarkResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    Page<Bookmark> findByTitleContainsIgnoreCase(String query, Pageable pageable);

}
