package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    void registerUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(int userId);
    void updateUser(int userId, String name, String email, String phone);
    void deleteUser(int userId);

    void addUser(User user);
}


