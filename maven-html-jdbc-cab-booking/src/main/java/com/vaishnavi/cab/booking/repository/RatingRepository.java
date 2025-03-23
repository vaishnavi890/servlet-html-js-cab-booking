package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingRepository {
    public void save(Rating rating) {
        String sql = "INSERT INTO ratings (ride_id, user_id, driver_id, rating, feedback) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rating.getRideId());
            statement.setInt(2, rating.getUserId());
            statement.setInt(3, rating.getDriverId());
            statement.setInt(4, rating.getRating());
            statement.setString(5, rating.getFeedback());
            statement.executeUpdate();
            System.out.println("Rating saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Rating> findById(int ratingId) {
        String sql = "SELECT * FROM ratings WHERE rating_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ratingId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Rating rating = new Rating(
                        resultSet.getInt("rating_id"),
                        resultSet.getInt("ride_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("driver_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("feedback")
                );
                return Optional.of(rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Rating> findAll() {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Rating rating = new Rating(
                        resultSet.getInt("rating_id"),
                        resultSet.getInt("ride_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("driver_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("feedback")
                );
                ratings.add(rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }

    public void update(Rating rating) {
        String sql = "UPDATE ratings SET ride_id = ?, user_id = ?, driver_id = ?, rating = ?, feedback = ? WHERE rating_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rating.getRideId());
            statement.setInt(2, rating.getUserId());
            statement.setInt(3, rating.getDriverId());
            statement.setInt(4, rating.getRating());
            statement.setString(5, rating.getFeedback());
            statement.setInt(6, rating.getRatingId());
            statement.executeUpdate();
            System.out.println("Rating updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ratingId) {
        String sql = "DELETE FROM ratings WHERE rating_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ratingId);
            statement.executeUpdate();
            System.out.println("Rating deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
