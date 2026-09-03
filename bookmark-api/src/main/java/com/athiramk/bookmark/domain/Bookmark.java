package com.athiramk.bookmark.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @SequenceGenerator(
            name = "bm_id_seq_gen",      // Unique name for the generator in application scope
            sequenceName = "bm_id_seq",  // Actual name of the sequence in the database
            initialValue = 1,               // The first value the sequence should start with
            allocationSize = 50             // Internal optimization step (must match DB increment)
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bm_id_seq_gen"  // Must precisely match the 'name' attribute above
    )
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    private Instant createdAt;


    public Bookmark() {
    }

    public Bookmark(Long id, String title, String url, Instant createdAt) {
        Id = id;
        this.title = title;
        this.url = url;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
