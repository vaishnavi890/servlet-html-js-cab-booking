package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.List;


public class UserController {
    private UserService userService = new UserService();

    // Add User
    public void addUser(User user) {
        userService.addUser(user);
    }

    // Get All Users
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    // Find User by ID
    public void getUserById(int userId) {
        User user = userService.findUserById(userId);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    // Delete User by ID
    public void deleteUserById(int userId) {
        userService.removeUser(userId);
    }
}
