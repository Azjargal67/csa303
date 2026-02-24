package com.lab02.task2;

public class UserRegistrationService {
    private final UserRepository userRepository;
    private final EmailValidator validator;

    public UserRegistrationService(UserRepository userRepository, EmailValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public void registerUser(String email, String password) {
        validator.validate(email);
        userRepository.save(new User(email, password));
    }
}