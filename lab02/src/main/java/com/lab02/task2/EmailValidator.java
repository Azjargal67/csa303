package com.lab02.task2;

public class EmailValidator {

    public void validate(String email) {
        if (email == null) throw new InvalidEmailException("Email cannot be null");
        if (!email.contains("@")) throw new InvalidEmailException("Email must contain @");
        if (email.length() < 5) throw new InvalidEmailException("Email too short");
        if (email.length() > 50) throw new InvalidEmailException("Email too long");
    }
}