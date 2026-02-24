package com.lab02.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private final EmailValidator validator = new EmailValidator();

    @Test
    void validEmail_passes() {
        assertDoesNotThrow(() -> validator.validate("test@example.com"));
    }

    @Test
    void nullEmail_fails() {
        InvalidEmailException ex = assertThrows(
                InvalidEmailException.class,
                () -> validator.validate(null)
        );
        assertEquals("Email cannot be null", ex.getMessage());
    }

    @Test
    void missingAt_fails() {
        InvalidEmailException ex = assertThrows(
                InvalidEmailException.class,
                () -> validator.validate("testexample.com")
        );
        assertEquals("Email must contain @", ex.getMessage());
    }

    @Test
    void tooShort_fails() {
        InvalidEmailException ex = assertThrows(
                InvalidEmailException.class,
                () -> validator.validate("a@b")
        );
        assertEquals("Email too short", ex.getMessage());
    }

    @Test
    void tooLong_fails() {
        String longEmail = "a".repeat(60) + "@x.com";
        InvalidEmailException ex = assertThrows(
                InvalidEmailException.class,
                () -> validator.validate(longEmail)
        );
        assertEquals("Email too long", ex.getMessage());
    }
}