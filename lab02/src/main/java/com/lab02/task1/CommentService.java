package com.lab02.task1;

public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final AuthorizationService auth;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, AuthorizationService auth) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.auth = auth;
    }

    public void editComment(Long commentId, Long userId, String newText) {
        Comment comment = commentRepository.findById(commentId);
        User user = userRepository.findById(userId);

        boolean allowed = auth.isAdmin(user) || auth.isOwner(userId, comment.getUserId());
        if (!allowed) {
            throw new UnauthorizedException("Cannot edit this comment");
        }

        comment.setText(newText);
        commentRepository.save(comment);
    }
}