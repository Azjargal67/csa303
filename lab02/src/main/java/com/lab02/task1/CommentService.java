package com.lab02;

public class CommentService {
    public void editComment(Long commentId, Long userId, String newText) {
        Comment comment = commentRepository.findById(commentId);
        User currentUser = userRepository.findById(userId);
        boolean isAdmin = currentUser.getRole().equals("ADMIN");
        boolean isOwner = comment.getUserId().equals(userId);
        if (!isAdmin && !isOwner) {
            throw new UnauthorizedException("Cannot edit this comment");
        }
        comment.setText(newText);
        commentRepository.save(comment);
    }
}