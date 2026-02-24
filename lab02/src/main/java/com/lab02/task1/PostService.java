package com.lab02;

public class PostService {
    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId);
        User user = userRepository.findById(userId);
        if (user.getRole().equals("ADMIN")) {
            postRepository.delete(post);
            return;
        }
        if (post.getAuthorId().equals(userId)) {
            postRepository.delete(post);
            return;
        }
        throw new UnauthorizedException("Cannot delete this post");
    }
}
