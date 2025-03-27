package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    private final UserService userService;

    // Constructor Injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add User
    public void addUser(User user) {
        try {
            userService.addUser(user);
            System.out.println(" User registered successfully!");
        } catch (Exception e) {
            System.err.println(" Error registering user: " + e.getMessage());
        }
    }

    // Get All Users
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            System.err.println(" Error fetching users: " + e.getMessage());
        }
        return null;
    }

    // Get User By ID
    public Optional<User> getUserById(int userId) {
        try {
            return userService.getUserById(userId);
        } catch (Exception e) {
            System.err.println(" Error fetching user: " + e.getMessage());
            return null;
        }
    }

    // Update User Details
    public void updateUser(int userId, String name, String email, String phone) {
        try {
            userService.updateUser(userId, name, email, phone);
            System.out.println(" User details updated successfully!");
        } catch (Exception e) {
            System.err.println(" Error updating user: " + e.getMessage());
        }
    }

    // Delete User
    public void deleteUser(int userId) {
        try {
            userService.deleteUser(userId);
            System.out.println(" User deleted successfully!");
        } catch (Exception e) {
            System.err.println(" Error deleting user: " + e.getMessage());
        }
    }
}


