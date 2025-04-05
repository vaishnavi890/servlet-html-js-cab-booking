package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.User;
import com.vaishnavi.servlet.cab.booking.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository repo = new UserRepository();

    public boolean registerUser(User user) {
        return repo.insertUser(user);
    }

    public User getUserById(int id) {
        return repo.getUserById(id);
    }

    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

    public void updateUser(User user) {
        repo.updateUser(user);
    }

    public void deleteUser(int id) {
        repo.deleteUser(id);
    }

    public void addUser(User user) {
    }
}



