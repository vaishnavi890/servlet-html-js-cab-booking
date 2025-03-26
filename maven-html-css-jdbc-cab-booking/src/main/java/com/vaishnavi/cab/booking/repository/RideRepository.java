package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RideRepository {
    public void save(Ride ride) {
        String sql = "INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ride.getUserId());
            statement.setInt(2, ride.getDriverId());
            statement.setString(3, ride.getPickupLocation());
            statement.setString(4, ride.getDropoffLocation());
            statement.setDouble(5, ride.getFare());
            statement.setString(6, ride.getStatus());
            statement.executeUpdate();
            System.out.println("Ride saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Ride> findById(int rideId) {
        String sql = "SELECT * FROM rides WHERE ride_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rideId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Ride ride = new Ride(resultSet.getInt("ride_id"), resultSet.getInt("user_id"), resultSet.getInt("driver_id"), resultSet.getString("pickup_location"), resultSet.getString("dropoff_location"), resultSet.getDouble("fare"), resultSet.getString("status"));
                return Optional.of(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Ride> findAll() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides";
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Ride ride = new Ride(resultSet.getInt("ride_id"), resultSet.getInt("user_id"), resultSet.getInt("driver_id"), resultSet.getString("pickup_location"), resultSet.getString("dropoff_location"), resultSet.getDouble("fare"), resultSet.getString("status"));
                rides.add(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }

    public void update(Ride ride) {
        String sql = "UPDATE rides SET user_id = ?, driver_id = ?, pickup_location = ?, dropoff_location = ?, fare = ?, status = ? WHERE ride_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ride.getUserId());
            statement.setInt(2, ride.getDriverId());
            statement.setString(3, ride.getPickupLocation());
            statement.setString(4, ride.getDropoffLocation());
            statement.setDouble(5, ride.getFare());
            statement.setString(6, ride.getStatus());
            statement.setInt(7, ride.getRideId());
            statement.executeUpdate();
            System.out.println("Ride updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int rideId) {
        String sql = "DELETE FROM rides WHERE ride_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rideId);
            statement.executeUpdate();
            System.out.println("Ride deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
