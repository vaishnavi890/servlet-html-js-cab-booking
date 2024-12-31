package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(User user) {
        if (!userRepository.containsUser(user.getUserId())) {
            userRepository.addUser(user);
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User already exists!");
        }
    }

    public void displayUsers() {
        userRepository.displayAllUsers();
    }
}
