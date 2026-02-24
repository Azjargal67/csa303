package com.lab02.task1;

public class User {
    private final Long id;
    private final Role role;

    public User(Long id, Role role){
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }
}
