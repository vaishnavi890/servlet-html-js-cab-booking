package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.*;

public class RatingRepository {
    private Map<Integer, Rating> ratingCache = new HashMap<>();

    // Add a new rating
    public void addRating(Rating rating) {
        String sql = "INSERT INTO Ratings (ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, rating.getRideId());
            stmt.setInt(2, rating.getUserId());
            stmt.setInt(3, rating.getDriverId());
            stmt.setInt(4, rating.getRating());
            stmt.setString(5, rating.getReview());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rating.setRatingId(rs.getInt(1));
                ratingCache.put(rating.getRatingId(), rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all ratings
    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM Ratings";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Rating rating = new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                );
                ratings.add(rating);
                ratingCache.put(rating.getRatingId(), rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }

    // Get rating by ID
    public Rating getRatingById(int ratingId) {
        return ratingCache.getOrDefault(ratingId, null);
    }

    // Update rating
    public void updateRating(int ratingId, int newRating, String newReview) {
        String sql = "UPDATE Ratings SET rating=?, review=? WHERE rating_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newRating);
            stmt.setString(2, newReview);
            stmt.setInt(3, ratingId);
            stmt.executeUpdate();

            if (ratingCache.containsKey(ratingId)) {
                Rating rating = ratingCache.get(ratingId);
                rating.setRating(newRating);
                rating.setReview(newReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete rating
    public void deleteRating(int ratingId) {
        String sql = "DELETE FROM Ratings WHERE rating_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ratingId);
            stmt.executeUpdate();
            ratingCache.remove(ratingId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




