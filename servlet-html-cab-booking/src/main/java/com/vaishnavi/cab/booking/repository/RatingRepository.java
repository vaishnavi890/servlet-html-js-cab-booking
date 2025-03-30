package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingRepository {

    public boolean addRating(Rating rating) {
        String query = "INSERT INTO ratings (ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rating.getRideId());
            stmt.setInt(2, rating.getUserId());
            stmt.setInt(3, rating.getDriverId());
            stmt.setInt(4, rating.getRating());
            stmt.setString(5, rating.getReview());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Rating> getRatingsByDriverId(int driverId) {
        List<Rating> ratings = new ArrayList<>();
        String query = "SELECT * FROM ratings WHERE driver_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, driverId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ratings.add(new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }
}



