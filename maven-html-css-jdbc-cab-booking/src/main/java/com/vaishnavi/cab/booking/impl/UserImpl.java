package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.User;
import java.util.List;
import java.util.Optional;

public interface UserImpl {
    void addUser(User user);
    Optional<User> getUserById(int userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);

    void saveUser(User user);
}
