package com.lab02.task1;

public class AuthorizationService {

    public boolean isAdmin(User user) {
        return user != null && user.getRole() == Role.ADMIN;
    }

    public boolean isOwner(Long userId, Long ownerId) {
        return userId != null && userId.equals(ownerId);
    }
}