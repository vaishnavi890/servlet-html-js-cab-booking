package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.service.UserService;
import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.exception.UserException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public void add(User user) throws UserException {
        if (user == null || user.getName().isEmpty()) {
            throw new UserException("Invalid user details!");
        }
        users.add(user);
        System.out.println("User added successfully: " + user.getName());
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() throws UserException {
        if (users.isEmpty()) {
            throw new UserException("No users found.");
        }
        return users;
    }

    @Override
    public void userOperations() {
        int choice;
        do {
            System.out.println("1. Register User");
            System.out.println("2. Display Users");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    try {
                        add(new User(userId, name, email, phone));
                    } catch (UserException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        getAll().forEach(user -> System.out.println(user.getName()));
                    } catch (UserException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }
        } while (choice != 3);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}