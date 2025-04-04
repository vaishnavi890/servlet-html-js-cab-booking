package com.vaishnavi.servlet.cab.booking.repository;

import com.vaishnavi.servlet.cab.booking.model.Ride;
import com.vaishnavi.servlet.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.*;

public class RideRepository {

    public boolean insertRide(Ride ride) {
        String sql = "INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ride.getUserId());
            ps.setInt(2, ride.getDriverId());
            ps.setString(3, ride.getPickupLocation());
            ps.setString(4, ride.getDropoffLocation());
            ps.setDouble(5, ride.getFare());
            ps.setString(6, ride.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public boolean removeRide(int rideId) {
        String sql = "DELETE FROM rides WHERE rides_id = ?";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rideId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rides.add(new Ride(
                        rs.getInt("rides_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup_location"),
                        rs.getString("dropoff_location"),
                        rs.getDouble("fare"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }
}



