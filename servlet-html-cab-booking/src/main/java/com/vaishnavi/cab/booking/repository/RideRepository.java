package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class RideRepository {

        public boolean addRide(Ride ride) {
            String query = "INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, ride.getUserId());
                stmt.setInt(2, ride.getDriverId());
                stmt.setString(3, ride.getPickupLocation());
                stmt.setString(4, ride.getDropoffLocation());
                stmt.setDouble(5, ride.getFare());
                stmt.setString(6, ride.getStatus());
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public List<Ride> getRides() {
            List<Ride> rideList = new ArrayList<>();
            String query = "SELECT * FROM rides";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    rideList.add(new Ride(
                            rs.getInt("ride_id"),
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
            return rideList;
        }

        public boolean updateRideStatus(int rideId, String status) {
            String query = "UPDATE rides SET status = ? WHERE ride_id = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, status);
                stmt.setInt(2, rideId);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }


