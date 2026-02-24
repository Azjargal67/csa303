package com.lab02.task1;

public interface PostRepository {
    Post findById(Long postId);
    void delete(Post post);
}