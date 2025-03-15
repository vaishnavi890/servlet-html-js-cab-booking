package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserRepository {
    private List<User> users = new ArrayList<>();

    // Save a new user
    public void saveUser(User user) {
        users.add(user);
        System.out.println("User saved successfully!");
    }

    // Get all users
    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }

    // Find user by ID
    public Optional<User> findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }

    // Remove user by ID
    public boolean deleteUserById(int userId) {
        return users.removeIf(user -> user.getUserId() == userId);
    }
}
