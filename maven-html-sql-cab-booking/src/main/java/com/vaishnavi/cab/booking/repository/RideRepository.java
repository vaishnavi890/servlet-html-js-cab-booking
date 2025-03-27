package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DBConnection;
import java.sql.*;
import java.util.*;

public class RideRepository {
    private Map<Integer, Ride> rideCache = new HashMap<>();

    public void addRide(Ride ride) {
        String sql = "INSERT INTO Rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, ride.getUserId());
            stmt.setInt(2, ride.getDriverId());
            stmt.setString(3, ride.getPickupLocation());
            stmt.setString(4, ride.getDropoffLocation());
            stmt.setDouble(5, ride.getFare());
            stmt.setString(6, ride.getStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ride.setRideId(rs.getInt(1));
                rideCache.put(ride.getRideId(), ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM Rides";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ride ride = new Ride(rs.getInt("ride_id"), rs.getInt("user_id"), rs.getInt("driver_id"),
                        rs.getString("pickup_location"), rs.getString("dropoff_location"),
                        rs.getDouble("fare"), rs.getString("status"));
                rides.add(ride);
                rideCache.put(ride.getRideId(), ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }

    public Ride getRideById(int rideId) {
        return rideCache.getOrDefault(rideId, null);
    }

    public void updateRideStatus(int rideId, String status) {
        String sql = "UPDATE Rides SET status=? WHERE ride_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, rideId);
            stmt.executeUpdate();

            if (rideCache.containsKey(rideId)) {
                Ride ride = rideCache.get(rideId);
                ride.setStatus(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRide(int rideId) {
        String sql = "DELETE FROM Rides WHERE ride_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rideId);
            stmt.executeUpdate();
            rideCache.remove(rideId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


