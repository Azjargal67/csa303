package com.lab02.task1;

public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthorizationService auth;

    public PostService(PostRepository postRepository, UserRepository userRepository, AuthorizationService auth) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.auth = auth;
    }

    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId);
        User user = userRepository.findById(userId);

        if (auth.isAdmin(user) || auth.isOwner(userId, post.getAuthorId())) {
            postRepository.delete(post);
            return;
        }

        throw new UnauthorizedException("Cannot delete this post");
    }
}