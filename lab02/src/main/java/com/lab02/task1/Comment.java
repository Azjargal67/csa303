package com.lab02.task1;

public class Comment {
    private final Long id;
    private final Long userId;
    private String text;

    public Comment(Long id, Long userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getText() { return text; }

    public void setText(String text) { this.text = text; }
}