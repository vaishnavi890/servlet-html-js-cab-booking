package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository {

    public boolean addDriver(Driver driver) {
        String query = "INSERT INTO drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getEmail());
            stmt.setString(3, driver.getPhone());
            stmt.setString(4, driver.getCabDetails());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Driver> getDrivers() {
        List<Driver> driverList = new ArrayList<>();
        String query = "SELECT * FROM drivers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                driverList.add(new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("cab_details")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverList;
    }
}


