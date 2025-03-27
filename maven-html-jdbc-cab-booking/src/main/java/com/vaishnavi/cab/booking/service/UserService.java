package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.impl.UserImpl;
import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserService implements UserImpl {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        try {
            userRepository.save(user);
            System.out.println("User added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userRepository.findById(userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(User user) {
        try {
            userRepository.update(user);
            System.out.println("User updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            userRepository.delete(userId);
            System.out.println("User deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

    @Override
    public void saveUser(User user) {

    }
}
