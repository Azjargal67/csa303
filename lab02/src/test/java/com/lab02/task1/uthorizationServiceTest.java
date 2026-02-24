package com.lab02.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationServiceTest {

    private final AuthorizationService auth = new AuthorizationService();

    @Test
    void isAdmin_returnsTrueForAdmin() {
        User admin = new User(1L, Role.ADMIN);
        assertTrue(auth.isAdmin(admin));
    }

    @Test
    void isAdmin_returnsFalseForUser() {
        User user = new User(2L, Role.USER);
        assertFalse(auth.isAdmin(user));
    }

    @Test
    void isOwner_returnsTrueWhenIdsMatch() {
        assertTrue(auth.isOwner(10L, 10L));
    }

    @Test
    void isOwner_returnsFalseWhenIdsDontMatch() {
        assertFalse(auth.isOwner(10L, 11L));
    }
}