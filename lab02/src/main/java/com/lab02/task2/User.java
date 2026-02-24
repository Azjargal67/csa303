package com.lab02.task2;

public class User {
    private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}