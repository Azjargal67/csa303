package com.lab02.task1;

public class Post {
    private final Long id;
    private final Long authorId;

    public Post(Long id, Long authorId) {
        this.id = id;
        this.authorId = authorId;
    }

    public Long getId() { return id; }
    public Long getAuthorId() { return authorId; }
}