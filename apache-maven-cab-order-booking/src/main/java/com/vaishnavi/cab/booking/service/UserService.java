package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserService {
    private List<User> users = new ArrayList<>();

    // Add User
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    // Get All Users
    public List<User> getAllUsers() {
        return users;
    }

    // Find User by ID
    public User findUserById(int userId) {
        Optional<User> user = users.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            System.out.println("User not found.");
            return null;
        }
    }

    // Remove User by ID
    public void removeUser(int userId) {
        if (users.removeIf(u -> u.getUserId() == userId)) {
            System.out.println("User removed successfully!");
        } else {
            System.out.println("User not found.");
        }
    }
}
