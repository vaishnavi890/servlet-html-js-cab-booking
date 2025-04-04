package com.vaishnavi.servlet.cab.booking.repository;

import com.vaishnavi.servlet.cab.booking.model.Driver;
import com.vaishnavi.servlet.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.*;

public class DriverRepository {

    public boolean insertDriver(Driver driver) {
        String sql = "INSERT INTO drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?)";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setString(3, driver.getPhone());
            ps.setString(4, driver.getCabDetails());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public boolean removeDriver(int id) {
        String sql = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Driver(
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
        return list;
    }
}



