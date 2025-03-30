package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;
import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public boolean registerUser(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("User name cannot be empty!");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        return userRepository.addUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getUser();
    }
}
