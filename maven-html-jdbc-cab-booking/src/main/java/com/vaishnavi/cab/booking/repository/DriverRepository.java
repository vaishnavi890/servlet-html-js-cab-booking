package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverRepository {
    public void save(Driver driver) {
        String sql = "INSERT INTO drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?)";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getEmail());
            statement.setString(3, driver.getPhone());
            statement.setString(4, driver.getCabDetails());
            statement.executeUpdate();
            System.out.println("Driver saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Driver> findById(int driverId) {
        String sql = "SELECT * FROM drivers WHERE driver_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, driverId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Driver driver = new Driver(resultSet.getInt("driver_id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("cab_details"));
                return Optional.of(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Driver> findAll() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Driver driver = new Driver(resultSet.getInt("driver_id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("cab_details"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public void update(Driver driver) {
        String sql = "UPDATE drivers SET name = ?, email = ?, phone = ?, cab_details = ? WHERE driver_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getEmail());
            statement.setString(3, driver.getPhone());
            statement.setString(4, driver.getCabDetails());
            statement.setInt(5, driver.getDriverId());
            statement.executeUpdate();
            System.out.println("Driver updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int driverId) {
        String sql = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, driverId);
            statement.executeUpdate();
            System.out.println("Driver deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
