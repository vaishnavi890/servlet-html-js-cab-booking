package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService implements UserServiceInterface {
    private UserRepository userRepository = new UserRepository();

    public UserService(UserRepository userRepository) {
    }

    @Override
    public void registerUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userRepository.getUserById(userId));
    }

    @Override
    public void updateUser(int userId, String name, String email, String phone) {
        userRepository.updateUser(userId, name, email, phone);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public void addUser(User user) {

    }
}


