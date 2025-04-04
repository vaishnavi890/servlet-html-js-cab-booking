package com.vaishnavi.servlet.cab.booking.repository;

import com.vaishnavi.servlet.cab.booking.model.Rating;
import com.vaishnavi.servlet.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.*;

public class RatingRepository {

    public boolean insertRating(Rating rating) {
        String sql = "INSERT INTO ratings (ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rating.getRideId());
            ps.setInt(2, rating.getUserId());
            ps.setInt(3, rating.getDriverId());
            ps.setInt(4, rating.getRating());
            ps.setString(5, rating.getReview());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public List<Rating> getAllRatings() {
        List<Rating> list = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Rating(
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
        return list;
    }
}


