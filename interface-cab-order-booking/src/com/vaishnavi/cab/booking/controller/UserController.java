package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.exception.UserException;
import com.vaishnavi.cab.booking.service.impl.UserServiceImpl;

import java.util.List;


public class UserController {
    private final UserServiceImpl userService = new UserServiceImpl() {
        // Register a new user with exception handling
        public void registerUser(int userId, String name, String email, String phone) {
            try {
                if (name == null || name.isEmpty()) {
                    throw new UserException("User name cannot be empty!");
                }
                User user = new User(userId, name, email, phone);
                userService.add(user);
                System.out.println("User Registered: " + name);
            } catch (UserException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        // Display all users with exception handling
        public void displayUsers() {
            try {
                List<User> users = userService.getAll();
                if (users.isEmpty()) {
                    throw new UserException("No users found.");
                }
                System.out.println("Registered Users:");
                users.forEach(user -> System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getName()));
            } catch (UserException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    };

    public void registerUser(int userId, String userName, String userEmail, String userPhone) {
    }

    public void displayUsers() {
    }
    }


