package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.DBConnection;
import java.sql.*;
import java.util.*;

public class DriverRepository {
    private Map<Integer, Driver> driverCache = new HashMap<>();

    public void addDriver(Driver driver) {
        String sql = "INSERT INTO Drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getEmail());
            stmt.setString(3, driver.getPhone());
            stmt.setString(4, driver.getCabDetails());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                driver.setDriverId(rs.getInt(1));
                driverCache.put(driver.getDriverId(), driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM Drivers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Driver driver = new Driver(rs.getInt("driver_id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("phone"), rs.getString("cab_details"));
                drivers.add(driver);
                driverCache.put(driver.getDriverId(), driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public Driver getDriverById(int driverId) {
        return driverCache.getOrDefault(driverId, null);
    }

    public void updateDriver(int driverId, String name, String email, String phone, String cabDetails) {
        String sql = "UPDATE Drivers SET name=?, email=?, phone=?, cab_details=? WHERE driver_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, cabDetails);
            stmt.setInt(5, driverId);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0 && driverCache.containsKey(driverId)) {
                driverCache.put(driverId, new Driver(driverId, name, email, phone, cabDetails));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDriver(int driverId) {
        String sql = "DELETE FROM Drivers WHERE driver_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, driverId);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                driverCache.remove(driverId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



