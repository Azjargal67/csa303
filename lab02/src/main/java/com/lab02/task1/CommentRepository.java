package com.lab02.task1;

public interface CommentRepository {
    Comment findById(Long commentId);
    void save(Comment comment);
}