package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.*;

public class UserRepository {
    private Map<Integer, User> userCache = new HashMap<>();

    public void addUser(User user) {
        String sql = "INSERT INTO Users (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUserId(rs.getInt(1));
                userCache.put(user.getUserId(), user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
                users.add(user);
                userCache.put(user.getUserId(), user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int userId) {
        return userCache.getOrDefault(userId, null);
    }

    public void updateUser(int userId, String name, String email, String phone) {
        String sql = "UPDATE Users SET name=?, email=?, phone=? WHERE user_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setInt(4, userId);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0 && userCache.containsKey(userId)) {
                userCache.put(userId, new User(userId, name, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE user_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                userCache.remove(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


