package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.executeUpdate();
            System.out.println("User saved successfully!");
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    // Find User by ID
    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding user by ID: " + e.getMessage());
        }
        return null;
    }

    // Find All Users
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = JdbcConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                ));
            }
            System.out.println("All users fetched successfully!");
        } catch (SQLException e) {
            System.err.println("Error fetching all users: " + e.getMessage());
        }
        return users;
    }

    // Update User
    public void update(int userId, String newPhone) {
        String sql = "UPDATE users SET phone = ? WHERE user_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newPhone);
            stmt.setInt(2, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    // Delete User
    public void delete(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

}
