package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    private UserService userService = null;

    public UserController() {
        this.userService = userService;
    }

    public void addUser() {
        try {
            User user = new User();
            userService.saveUser(user);
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    public void getUserById(int userId) {
        try {
            Optional<User> user = userService.getUserById(userId);
            user.ifPresentOrElse(
                    u -> System.out.println("User found: " + u),
                    () -> System.out.println("User not found.")
            );
        } catch (Exception e) {
            System.err.println("Error fetching user: " + e.getMessage());
        }
    }

    public void getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            users.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching users: " + e.getMessage());
        }
    }

    public void updateUser() {
        try {
            User user = new User();
            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser() {
        try {
            int userId = 0;
            userService.deleteUser(userId);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}